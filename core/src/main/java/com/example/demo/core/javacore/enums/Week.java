package com.example.demo.core.javacore.enums;

public enum Week {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private int num;

    Week(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        System.out.println(Week.MONDAY.toString());
    }
}
