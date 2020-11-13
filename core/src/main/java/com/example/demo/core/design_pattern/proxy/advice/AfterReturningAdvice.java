package com.example.demo.core.design_pattern.proxy.advice;

public class AfterReturningAdvice implements Advice {

    public void afterReturning() {
        System.out.println("afterReturning advice...");
    }
}
