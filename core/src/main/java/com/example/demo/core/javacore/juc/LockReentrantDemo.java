package com.example.demo.core.javacore.juc;

public class LockReentrantDemo {

    public static void main(String[] args) {
        Widget widget = new LoggingWidget();
        widget.doSomething();

    }

    public static class Widget {
        public synchronized void doSomething() {
            System.out.println(toString() + ": calling doSomething");
        }
    }

    public static class LoggingWidget extends Widget {
        public synchronized void doSomething() {
            System.out.println(toString() + ": calling doSomething");
            super.doSomething();// 子类调用父类方法
        }
    }
}

