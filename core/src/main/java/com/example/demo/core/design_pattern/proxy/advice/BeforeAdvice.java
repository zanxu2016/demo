package com.example.demo.core.design_pattern.proxy.advice;

public class BeforeAdvice implements Advice {

    public void before() {
        System.out.println("before advice...");
    }
}
