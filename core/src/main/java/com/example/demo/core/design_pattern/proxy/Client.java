package com.example.demo.core.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;

public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler myIH = new MyInvocationHandler(subject);
        Subject proxy = (Subject) DynamicProxy.newInstance(subject.getClass(), myIH);
        proxy.action();
    }
}
