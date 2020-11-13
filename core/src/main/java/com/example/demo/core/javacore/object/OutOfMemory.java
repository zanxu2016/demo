package com.example.demo.core.javacore.object;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {
    private static final int size = Integer.MAX_VALUE;
    private List<A> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        OutOfMemory oom = new OutOfMemory();

        for (int i = 0; i < size; i++) {
            oom.list.add(new A());

            Thread.sleep(10);
        }
    }

    static class A {
        private List<Object> objs = new ArrayList<>(10000);
    }
}
