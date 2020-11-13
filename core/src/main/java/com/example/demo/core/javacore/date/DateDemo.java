package com.example.demo.core.javacore.date;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class DateDemo {

    public static void main(String[] args) {
        Date date = DateUtils.addHours(new Date(), 1);
        System.out.println(new Date());
        System.out.println(date);
    }
}
