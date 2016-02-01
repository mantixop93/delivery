package com.lab.delivery.service.pizza;

import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.pizza.PizzaRepository;
import com.lab.delivery.service.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mantixop on 1/21/16.
 */

@Service
public class SimplePizzaService implements PizzaService {

    PizzaRepository repository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) {
        repository = pizzaRepository;
    }

    public Pizza find(Integer id) {
        return repository.findById(id);
    }
}
