package com.lab.delivery.service.pizza;

import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.pizza.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Mantixop on 1/21/16.
 */

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
public class SimplePizzaService implements PizzaService {

    PizzaRepository repository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) {
        repository = pizzaRepository;
    }

    public Pizza find(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Collection<Pizza> getAll() {
        return repository.getAll();
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        repository.save(pizza);
        return pizza;
    }
}
