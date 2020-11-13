package com.example.demo.core.tools.stopwatch;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchDemo {

    public static void main(String[] args) {
        StopWatch stopWatch = StopWatch.create();

        System.out.println(stopWatch.isStarted());// false
        System.out.println(stopWatch.isStopped());// true

        stopWatch.start();

        sleep();

        stopWatch.split();

        long t1 = stopWatch.getSplitTime();

        System.out.println(t1);// 2000

        sleep();

        stopWatch.split();

        long t2 = stopWatch.getSplitTime();

        System.out.println(t2 - t1);// 4000

        sleep();

        stopWatch.split();

        long t3 = stopWatch.getSplitTime();

        System.out.println(t3 - t2);
        stopWatch.stop();

        System.out.println(stopWatch.getTime());// 6000

    }

    public static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
