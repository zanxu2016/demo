package com.example.demo.core.javacore.lambda;

import org.junit.Test;

public class LambdaDemo {

    @Test
    public void test() {
//        Thread t = new Thread(() -> System.out.println(123444));
//        t.start();

        LambdaDemo demo = new LambdaDemo();
        demo.print();
        demo.log();
    }

    private void print() {
        System.out.println("111111");
    }

    public void log() {
        System.out.println("2222");
    }
}

interface A {
    void a();
}

class B implements A {

    @Override
    public void a() {

    }
}
