package com.example.demo.core.design_pattern.responsibilitychain;

public class Concrete2Handler extends BaseHandler {

    public void doHandle(Request request) {
        System.out.println("handle 2 request");
    }

    public boolean canHandle(Request request) {
        return true;
    }
}
