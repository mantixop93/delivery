package com.lab.delivery.service;

import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.InMemPizzaRepository;
import com.lab.delivery.repository.PizzaRepository;
import com.lab.delivery.tools.ServiceLocator;

/**
 * Created by Mantixop on 1/21/16.
 */
public class SimplePizzaService implements  PizzaService {

    PizzaRepository repository = (PizzaRepository) ServiceLocator.getInstance().getService("pizzaRepository");

    public Pizza find(Integer id) {
        return repository.findById(id);
    }
}
