package com.example.demo.core.design_pattern.proxy.advice;

public class AfterAdvice implements Advice {

    public void after() {
        System.out.println("after advice...");
    }
}
