package com.example.demo.core.javacore.juc;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Lock {

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1  = new MyThread();

//        Thread daemon = new Thread(new MyRunnable());
//        daemon.setDaemon(true);

        t1.start();
//        daemon.start();
        while (true) {
            System.out.println("t1 is alive? " + t1.isAlive());
            if (!t1.isAlive()) {
                System.err.println("t1 is NOT alive.");
                break;
            }
        }

        System.out.println("main thread sleep...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main thread finish...");
    }

    static class MyRunnable implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("my runnable do run...");
            System.out.println("my runnable sleep...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("my runnable finish run...");
        }
    }

    static class MyThread extends Thread {
        @SneakyThrows
        public void run() {
//            System.out.println("myThread run...");
//            System.out.println("myThread sleep...");

//            Thread thread = new Thread(new DeadLoop());
//            thread.setDaemon(true);
//            thread.start();

//            TimeUnit.MICROSECONDS.sleep(1000);
//            System.out.println("myThread finish...");
        }
    }

    static class DeadLoop implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                System.out.println("dead loop...");
                TimeUnit.MICROSECONDS.sleep(100);
            }
        }
    }
}
