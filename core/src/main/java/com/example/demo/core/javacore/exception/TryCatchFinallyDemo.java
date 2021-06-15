package com.example.demo.core.javacore.exception;

import org.junit.Test;

public class TryCatchFinallyDemo {

    @Test
    public void test1() {
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ClassCastException();
        } finally {
            throw new IllegalArgumentException();// 最终抛出的异常
        }
    }

    @Test
    public void test2() {
        try {
            throw new ArrayIndexOutOfBoundsException();// 最终抛出的异常
        } catch (ArithmeticException e) {
            throw new ClassCastException();
        } finally {
            System.out.println(123);
        }
    }

    public static void main(String[] args) {
//        throw new RuntimeException();// 签名上不需要throws
//        throw new Exception();// 签名上throws，或者，try...catch...

        try {
            System.out.println("try block start");
            throwEx("111", null);
            System.out.println("try block end");
        } catch (Exception e) {
            System.out.println("catch block start");
            e.printStackTrace();
            throwEx("222", e);
            System.out.println("catch block end");
        } finally {// 尽量不要在finally中retur或抛异常，会覆盖原异常
//            throwEx("333", null);
            return;
        }
    }

    public static void throwEx(String name, Throwable t) {
        System.out.println("throwEx " + name);
        throw new RuntimeException(name, t);
    }


}
