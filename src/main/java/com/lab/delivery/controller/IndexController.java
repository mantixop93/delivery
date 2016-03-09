package com.lab.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mantixop on 3/9/16.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewPizzas() {
        return "redirect:pizza/pizzas";
    }
}
