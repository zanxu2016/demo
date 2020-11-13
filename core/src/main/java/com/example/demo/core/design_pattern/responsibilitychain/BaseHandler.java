package com.example.demo.core.design_pattern.responsibilitychain;

import lombok.SneakyThrows;

import java.util.Objects;

public abstract class BaseHandler implements Handler {

    private Handler next;

    @SneakyThrows
    @Override
    public void setNext(Handler next) {
        if (next == this) {
            throw new Exception("cycle next!");
        }
        this.next = next;
    }

    public Handler getNext() {
        return this.next;
    }

    @Override
    public void handle(Request request) {

        if (canHandle(request)) {
            this.doHandle(request);
        } else if (!canHandle(request) && Objects.nonNull(this.next)) {
            next.handle(request);
        }
    }

    public boolean canHandle(Request request) {
        return true;
    }

    abstract void doHandle(Request request);
}
