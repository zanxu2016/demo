package com.example.demo.core.design_pattern.responsibilitychain;

import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.LinkedList;

public class HandlerChain {
    private LinkedList<Handler> handlerChain;

    public void handle(Request request) {
        if (CollectionUtils.isEmpty(handlerChain)) return;
        handlerChain.getFirst().handle(request);
    }

    public void register(Handler handler) {
        if (CollectionUtils.isEmpty(handlerChain)) {
            handlerChain = new LinkedList<>();
        }

        // 第一次添加节点
        if (handlerChain.size() == 0) {
            handlerChain.addFirst(handler);
        } else {
            handlerChain.getLast().setNext(handler);
            handlerChain.addLast(handler);
        }
    }
}
