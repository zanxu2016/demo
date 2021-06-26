package com.example.demo.core.javacore.juc;

public class ThreadDemo {
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            System.out.println("aaaaaaa");
//        },"aaa");
//        thread.setDaemon(true);
//        thread.start();
//        Thread.sleep(100);
//
//        System.out.println("bbbbbb");
//        Thread.sleep(1000);
//        System.out.println("cccc");
//        System.exit(0);
//        System.out.println("dddddd");
//    }

    static int num = 0;
    static volatile boolean flag = false;// 信号

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (100 > num) {
                if (!flag && (num == 0 || ++num % 2 == 0)) {
                    System.out.println(num + " >> " + Thread.currentThread().getName());
                    flag = true;
                }
            }
        }
        );

        Thread t2 = new Thread(() -> {
            while (100 > num) {
                if (flag && (++num % 2 != 0)) {
                    System.out.println(num + " >> " + Thread.currentThread().getName());
                    flag = false;
                }
            }
        }
        );

        t1.start();
        t2.start();
    }
}
