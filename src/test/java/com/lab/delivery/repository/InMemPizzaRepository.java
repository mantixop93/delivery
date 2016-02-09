package com.lab.delivery.repository;

import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.pizza.PizzaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mantixop on 1/21/16.
 */

@Repository
public class InMemPizzaRepository implements PizzaRepository {

    private Map<Integer, Pizza> pizzasDB;


    public InMemPizzaRepository() {
        pizzasDB = new HashMap<Integer, Pizza>();
    }

    public Map<Integer, Pizza> getPizzasDB() {
        return pizzasDB;
    }

    public void setPizzasDB(Map<Integer, Pizza> pizzasDB) {
        this.pizzasDB = pizzasDB;
    }

    @PostConstruct
    public void init() {
        pizzasDB.put(1, new Pizza(1, "Sea", 20, Pizza.PizzaType.SEA));
        pizzasDB.put(2, new Pizza(2, "Meat", 10, Pizza.PizzaType.MEAT));
        pizzasDB.put(3, new Pizza(3, "Vegetarian", 30, Pizza.PizzaType.VEGETERIAN));
    }


    public Pizza findById(Integer id) {
        return pizzasDB.get(id);
    }
}