package com.lab.delivery;
import com.lab.delivery.domain.Address;
import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;
import com.lab.delivery.domain.Pizza;
import com.lab.delivery.repository.pizza.PizzaRepository;
import com.lab.delivery.service.order.OrderService;
import com.lab.delivery.service.order.SimpleOrderService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mantixop on 1/27/16.
 */
public class SpringDeliveryApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml", "repositoryContext.xml"});
        SimpleOrderService orderService = applicationContext.getBean("orderService", SimpleOrderService.class);
        Order  order = orderService.placeNewOrder(new Customer(1,"123", new Address(1, "Kyiv"), 100), 1,1,1,1,1);
        System.out.println(order);
        orderService.cookOrder(order);
        System.out.println(order);
        System.out.println(orderService.payOrder(order));
    }
}
