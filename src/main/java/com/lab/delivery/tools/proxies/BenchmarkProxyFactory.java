package com.lab.delivery.tools.proxies;

import com.lab.delivery.tools.annotations.Benchmark;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * Created by Mantixop on 1/27/16.
 */
public class BenchmarkProxyFactory {
    public static Object getBenchmarkProxy(final Object o) {
        return  Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Method m = o.getClass().getMethod(method.getName(), method.getParameterTypes());
                if (m.isAnnotationPresent(Benchmark.class)) {
                    System.out.println("Method '" + method.getName() + "' have started working.");
                    long start = System.nanoTime();
                    Object result =  method.invoke(o, args);
                    System.out.println("Method '" + method.getName() + "' have finished working.\n" +
                            "Total time: " + (System.nanoTime() - start) + " nanoseconds") ;
                    return result;
                } else {
                    return method.invoke(o, args);
                }
            }
        });
    }
}
