package com.lab.delivery.service.pizza;

import com.lab.delivery.domain.Pizza;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface PizzaService {
    Pizza find(Integer id);
    Collection<Pizza> getAll();
    Pizza save(Pizza pizza);
}
