package com.example.demo.core.design_pattern.proxy.advice;

public class AfterThrowingAdvice implements Advice {

    public void afterThrowing() {
        System.out.println("afterThrowing advice...");
    }
}
