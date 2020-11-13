package com.example.demo.core.design_pattern.responsibilitychain;

import org.junit.Test;

public class TestDemo {

    @Test
    public void test() {
//        Handler handler1 = new ConcreteHandler();
//        Handler handler2 = new Concrete2Handler();
//
//        handler1.setNext(handler2);
//
//        handler1.handle(new Request());


        // 责任链模式
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.register(new ConcreteHandler());
        handlerChain.register(new Concrete2Handler());

        handlerChain.handle(new Request());

    }
}
