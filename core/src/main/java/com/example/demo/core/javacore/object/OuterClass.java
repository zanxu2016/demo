package com.example.demo.core.javacore.object;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class OuterClass {
    private String name;
    private class InnerClass {
        public InnerClass(String aaa) {
            name = aaa;
        }
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.addDays(new Date(), 30));
    }
}
