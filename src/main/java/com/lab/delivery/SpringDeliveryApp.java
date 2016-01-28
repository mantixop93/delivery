package com.lab.delivery;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mantixop on 1/27/16.
 */
public class SpringDeliveryApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
        System.out.println(applicationContext.getBean("pizzaRepo"));
    }
}
