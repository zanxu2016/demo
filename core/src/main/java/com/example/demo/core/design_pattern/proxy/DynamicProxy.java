package com.example.demo.core.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static Object newInstance(Class<?> clazz, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), invocationHandler);
    }
}
