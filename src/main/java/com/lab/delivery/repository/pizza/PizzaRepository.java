package com.lab.delivery.repository.pizza;

import com.lab.delivery.domain.Pizza;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mantixop on 1/21/16.
 */

public interface PizzaRepository {
    Pizza findById(Integer id);
    List getAll();
    Pizza save(Pizza pizza);
}
