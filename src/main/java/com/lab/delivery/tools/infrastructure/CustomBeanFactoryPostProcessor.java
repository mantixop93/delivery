package com.lab.delivery.tools.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

/**
 * Created by Mantixop on 2/3/16.
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("newCustomer");
        ConstructorArgumentValues argumentValues = beanDefinition.getConstructorArgumentValues();
        System.out.println(argumentValues.getArgumentCount());
       // ConstructorArgumentValues.ValueHolder valueHolder = argumentValues.getArgumentValue(0, null);
       // System.out.println(valueHolder.getValue());
    }
}
