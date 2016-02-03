package com.lab.delivery.tools.infrastructure;

import com.lab.delivery.domain.Pizza;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Mantixop on 2/3/16.
 */
public class PizzaFactoryBean implements FactoryBean <Pizza> {

    private Integer id;
    private String name;
    private Pizza.PizzaType type;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pizza.PizzaType getType() {
        return type;
    }

    public void setType(Pizza.PizzaType type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Pizza getObject() throws Exception {
        return new Pizza(id, name, price, type);
    }

    public Class<?> getObjectType() {
        return Pizza.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
