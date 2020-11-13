package com.example.demo.core.tools.date;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.getInstance;

public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat();

    public static String toStr(Date date, String pattern) {
        FORMATTER.applyPattern(pattern);
        return FORMATTER.format(date);
    }

    @SneakyThrows
    public static Date toDate(String date) {
        return FORMATTER.parse(date);
    }

    public static String nowDateToStr() {
        return toStr(new Date(), DATE_FORMAT);
    }

    public static String nowDateTimeToStr() {
        return toStr(new Date(), DATE_TIME_FORMAT);
    }

    public static String nowToStr(String pattern) {
        return toStr(new Date(), pattern);
    }

    public static long timestamp(Date date) {
        return date.getTime();
    }

    public static long timestamp(String date) {
        return timestamp(toDate(date));
    }

    public static Date getMonthFirstDay(@NonNull Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static String getFirstDate(Date date) {
        Calendar ca = getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        return toStr(ca.getTime(), DATE_FORMAT);
    }

    public static String getFirstDate(Date date, String pattern) {
        Calendar ca = getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        return toStr(ca.getTime(), pattern);
    }

    @Test
    public void test() {
        System.out.println(toStr(getMonthFirstDay(new Date()), DATE_TIME_FORMAT));

        System.out.println(getFirstDate(new Date()));
        System.out.println(getFirstDate(new Date(), DATE_TIME_FORMAT));
    }
}
