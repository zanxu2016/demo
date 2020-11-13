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
}
