package com.example.demo.core.javacore.juc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MyBlockingQueue<T> {

    /**
     * 队列长度默认为10
     */
    private int limit = 10;
    private final Queue<T> queue = new LinkedList<>();

    /**
     * 初始化队列容量
     *
     * @param limit 队列容量
     */
    public MyBlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * 入队列
     *
     * @param t 队列元素
     * @throws InterruptedException
     */
    public synchronized boolean push(T t) throws InterruptedException {
        // 如果队列已满，再来添加队列的线程就直接阻塞等待。
        while (this.queue.size() == this.limit) {
            System.out.println("push >> full in queue");
            wait();
        }
        // 如果队列为空了，就唤醒所有阻塞的线程。
        if (this.queue.size() == 0) {
            System.out.println("push >> no item in queue");
            notifyAll();
        }
        // 入队
        boolean add = this.queue.offer(t);
        return add;
    }

    /**
     * 出队列
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized T pop() throws InterruptedException {
        // 如果出队列时，队列为空，则阻塞队列。
        while (this.queue.size() == 0) {
            System.out.println("pop >> no item in queue");
            wait();
        }
        // 如果队列重新满了之后，唤醒阻塞的所有线程。
        if (this.queue.size() == this.limit) {
            System.out.println("pop >> full in queue");
            notifyAll();
        }
        T poll = this.queue.poll();
        return poll;
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
        new Thread(() -> {
            while (true) {
                boolean push = false;
                try {
                    int randomInt = new Random().nextInt(1000);
                    push = queue.push(randomInt);
                    System.out.println(Thread.currentThread().getName() + " -> push " + randomInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }, "producer").start();

        new Thread(() -> {
            while (true) {
                Integer pop = null;
                try {
                    pop = queue.pop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> pop " + pop);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }, "consumer").start();

    }
}

