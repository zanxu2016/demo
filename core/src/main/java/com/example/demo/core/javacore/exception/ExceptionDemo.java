package com.example.demo.core.javacore.exception;

import java.util.ArrayList;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println(test1());
//        System.out.println();
//        test2();
    }

    public static int test1() {
        try {
//            int num = 1 / 0;
            return 1;
        } finally {
            return 3;
        }
    }

    public static int test2() {
        try {
            int num = 1 / 0;
            return 1;
        } catch (Exception e){
            return 2;
        }
    }


    public static int test3() {
        try {
//            System.out.println("try block before ex");
            int num = 1 / 0;
//            System.out.println("try block after ex");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("catch block");
            return 2;
        } finally {
//            System.out.println("finally block");
            return 3;
        }

//        System.out.println("method exit");
    }

    public static void test4() {
        for (int i = 0; i < 100; i++) {
            System.out.println("==============" + i);
            try {
                System.out.println("try block");
                if (i < 50) {
                    continue;
                } else if (i < 80) {
                    new ArrayList<>(-1);
//                    break;
                } else {
                    int a = 1 / 0;
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("catch illegalArgument block");
                return;
            } catch (ArithmeticException e) {
                System.out.println("catch arithmetic block");
                return;
            } finally {
                System.out.println("finally block");
            }
        }
        System.out.println("method exit");
    }
}
