package com.lab.delivery.tools.infrastructure;

import com.lab.delivery.tools.annotations.Benchmark;
import com.lab.delivery.tools.proxies.BenchmarkProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Mantixop on 2/3/16.
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return BenchmarkProxyFactory.checkForBenchmarkAndGetProxy(o);
    }
}
