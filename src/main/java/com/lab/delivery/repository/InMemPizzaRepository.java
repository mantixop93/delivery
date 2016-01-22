package com.lab.delivery.repository;

import com.lab.delivery.domain.Pizza;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mantixop on 1/21/16.
 */
public class InMemPizzaRepository implements PizzaRepository {

    private static final Map<Integer, Pizza> pizzasDB = new HashMap<Integer, Pizza>();
    {
        pizzasDB.put(1, new Pizza(1,"Sea",20d,Pizza.PizzaTipe.Sea));
        pizzasDB.put(2, new Pizza(2,"Meat",10d,Pizza.PizzaTipe.Meat));
        pizzasDB.put(3, new Pizza(3,"Vegetarian",30d,Pizza.PizzaTipe.Vegetarian));
    }


    public Pizza findById(Integer id) {
        return pizzasDB.get(id);
    }
}
