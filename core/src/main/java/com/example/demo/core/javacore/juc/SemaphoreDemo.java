package com.example.demo.core.javacore.juc;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    @SneakyThrows
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < 11; i++) {
            new Thread(new MyThread(String.valueOf(i), semaphore)).start();
        }
    }

    static class MyThread implements Runnable {

        private String name;

        private Semaphore semaphore;

        public MyThread(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
        }

        @SneakyThrows
        @Override
        public void run() {
            if (semaphore.tryAcquire()) {
                System.out.println("Thread " + this.name + " is running...");
                TimeUnit.SECONDS.sleep(5);
                semaphore.release();
            } else {
                System.out.println("can not acquire...");
            }
        }
    }
}
