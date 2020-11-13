package com.example.demo.core.delay_queue.jdk;

import com.alibaba.fastjson.JSON;
import com.example.demo.core.tools.date.DateUtil;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class DelayMessageTest {

    public static void main(String[] args) {
        final DelayQueue<OrderMessage> delayQueue = new DelayQueue<>();

        new Thread(() -> {
            while (true) {
                delayQueue.add(new OrderMessage("" + randomInt(), DateUtil.nowDateToStr(), "delay queue message"));
                sleep(1);
            }
        }).start();


        // 启动一个线程，处理延迟消息
        Executors.newSingleThreadExecutor().execute(() -> {
            OrderMessage message;
            while (true) {
                try {
                    System.out.println("take message from delay queue...");
                    message = delayQueue.take();// 取不到数据就阻塞
                    System.out.println(new Date() + "  处理延迟消息:  " + JSON.toJSONString(message));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SneakyThrows
    private static void sleep(long seconds) {
        Thread.sleep(seconds * 1000);
    }

    private static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100);
    }
}
