package com.example.demo.core.javacore.juc;

import org.junit.Test;

public class ObjectLock {
    final Object lock = new Object();

    @Test
    public void testWaitNotify() {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("sleep for a while, " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                waitTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
                System.out.println("sleep for a while, " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyTest();
        })
                .start();


        new Thread(() -> {
            try {
                System.out.println("start sleep for a while, " + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("end sleep, " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                waitTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("start sleep for a while, " + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("end sleep, " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyTest();
        })
                .start();
    }

    public void waitTest() throws InterruptedException {
        synchronized (lock) {
            System.out.println("wait start");
            lock.wait();
            System.out.println("wait end");
        }
    }

    public void notifyTest() {
        synchronized (lock) {
            System.out.println("notify start");
            lock.notifyAll();
            System.out.println("notify end");
        }
    }
}
