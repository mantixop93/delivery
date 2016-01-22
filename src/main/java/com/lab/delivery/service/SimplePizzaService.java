package com.lab.delivery.service;

import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.InMemPizzaRepository;
import com.lab.delivery.repository.PizzaRepository;

/**
 * Created by Mantixop on 1/21/16.
 */
public class SimplePizzaService implements  PizzaService {

    PizzaRepository repository = new InMemPizzaRepository();

    public Pizza find(Integer id) {
        return repository.findById(id);
    }
}
