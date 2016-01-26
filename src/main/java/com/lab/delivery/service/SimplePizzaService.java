package com.lab.delivery.service;

import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.InMemPizzaRepository;
import com.lab.delivery.repository.PizzaRepository;
import com.lab.delivery.tools.ServiceLocator;

/**
 * Created by Mantixop on 1/21/16.
 */
public class SimplePizzaService implements  PizzaService {

    PizzaRepository repository;

    public SimplePizzaService(PizzaRepository pizzaRepository) {
        repository = pizzaRepository;
    }

    public Pizza find(Integer id) {
        return repository.findById(id);
    }
}
