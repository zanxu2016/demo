package com.example.demo.core.design_pattern.responsibilitychain;

public class ConcreteHandler extends BaseHandler {

    public void doHandle(Request request) {
        System.out.println("handle request");
    }

    public boolean canHandle(Request request) {
        return false;
    }
}
