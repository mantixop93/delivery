package com.lab.delivery.tools;

import com.lab.delivery.tools.annotations.PostCreate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mantixop on 1/25/16.
 */
public class JavaConfigApplicationContext implements ApplicationContext {

    private Config config;
    private Map<String, Object> cache = new HashMap<String, Object>();

    public JavaConfigApplicationContext(Config config) {
        this.config = config;
    }

    public Object getBean(String beanName) {

        if (cache.containsKey(beanName)) {
            return cache.get(beanName);
        } else {
            Class<?> type = config.getImpl(beanName);

            BeanBuilder builder = new BeanBuilder(type);
            builder.construct();
            builder.afterConstruct();
            builder.createProxy();
            Object object = builder.build();

            cache.put(beanName, object);
            return object;
        }
    }

    class BeanBuilder {

        Class<?> type;
        Object bean;

        public BeanBuilder(Class<?> type) {
            this.type = type;
        }

        public void construct(){
            try {
                Constructor<?> constructor = type.getConstructors()[0];
                Parameter[] parameters = constructor.getParameters();
                if (parameters.length == 0){
                    bean = type.newInstance();
                } else {
                    Object[] params = new Object[parameters.length];

                    for (int i = 0; i < params.length; i++) {
                        char[] name = parameters[i].getType().getSimpleName().toCharArray();
                        name[0] = Character.toLowerCase(name[0]);
                        params[i] = getBean(String.valueOf(name));
                    }

                    bean = constructor.newInstance(params);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        public void afterConstruct() {
            Class<?> clazz = bean.getClass();
            try {

                for (Method method : clazz.getMethods()) {
                    if(method.isAnnotationPresent(PostCreate.class)) {
                        method.invoke(bean);
                    }
                }

                for (Method method : clazz.getMethods()) {
                    if (method.getName().equals("init") && !(method.isAnnotationPresent(PostCreate.class))) {
                        method.invoke(bean);
                    }
                }

            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        public void createProxy() {

        }

        public Object build() {
            return bean;
        }
    }
}
