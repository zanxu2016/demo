package com.example.demo.core.design_pattern.proxy;

public class RealSubject implements Subject {
    @Override
    public void action() {
        System.out.println("real subject do action...");
    }
}
