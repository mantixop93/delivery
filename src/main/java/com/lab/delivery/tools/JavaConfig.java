package com.lab.delivery.tools;

import com.lab.delivery.repository.pizza.InMemPizzaRepository;
import com.lab.delivery.repository.order.InMemOrderRepository;
import com.lab.delivery.service.order.SimpleOrderService;
import com.lab.delivery.service.pizza.SimplePizzaService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mantixop on 1/22/16.
 */
public class JavaConfig implements Config {
    private Map<String,Class<?>> ifc2Class = new HashMap<String, Class<?>>();

    public JavaConfig() {
        ifc2Class.put("pizzaRepository", InMemPizzaRepository.class);
        ifc2Class.put("orderRepository", InMemOrderRepository.class);
        ifc2Class.put("orderService", SimpleOrderService.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
    }


    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
