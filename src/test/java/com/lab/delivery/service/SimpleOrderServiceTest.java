package com.lab.delivery.service;

import com.lab.delivery.domain.Customer;
import com.lab.delivery.domain.Order;
import com.lab.delivery.service.order.OrderService;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Mantixop on 2/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/appContext.xml", "classpath:/repositoryTestContext.xml"})
public class SimpleOrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testPlaseOrder() {
        System.out.println("test place order");
        Customer customer = null;

        Order order = orderService.placeNewOrder(customer, new Integer(1));
        System.out.println(order);
        assertNotNull(order);
    }
}
