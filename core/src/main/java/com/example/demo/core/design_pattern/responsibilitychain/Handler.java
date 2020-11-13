package com.example.demo.core.design_pattern.responsibilitychain;

public interface Handler {

    void setNext(Handler next);

    void handle(Request request);

    boolean canHandle(Request request);

    Handler getNext();
}
