package com.lab.delivery.controller;

import com.lab.delivery.domain.Pizza;
import com.lab.delivery.service.pizza.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Mantixop on 2/15/16.
 */

@Controller
@RequestMapping("pizza")
public class PizzaController {


    PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @RequestMapping(value = "/pizzas")
    public String showPizzas(Map<String, Object> model){
        model.put("pizzas", pizzaService.getAll());
        return "pizza/list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @ResponseBody
    public String viewById(@RequestParam("id") Integer pizzaId) {
        return pizzaService.find(pizzaId).toString();
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String cratePizza(Model model) {
        model.addAttribute("types", Pizza.PizzaType.values());
        return "pizza/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String updatePizza(Model model, @RequestParam("id") Integer pizzaId) {
        model.addAttribute("pizza", pizzaService.find(pizzaId));
        model.addAttribute("types", Pizza.PizzaType.values());
        return "pizza/edit";
    }

    //TODO: deactivate pizza

    @RequestMapping(value = "/deactivate", method = RequestMethod.POST)
    public String deactivatePizza() {

        return "redirect:pizzas";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute Pizza pizza, BindingResult result) {
        if (result.hasErrors()) {
            return "pizza/edit";
        } else {
            pizzaService.save(pizza);
            return "redirect:pizzas";
        }
    }
}
