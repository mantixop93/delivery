package com.lab.delivery.repository;

import com.lab.delivery.domain.Pizza;

/**
 * Created by Mantixop on 1/21/16.
 */
public interface PizzaRepository {
    Pizza findById(Integer id);
    void init();
    void myInit();
}
