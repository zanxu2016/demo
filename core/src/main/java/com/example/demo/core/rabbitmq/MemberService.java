package com.example.demo.core.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MemberService {
    //发送欢迎消息的状态
    private Map<Long, Boolean> welcomeStatus = new ConcurrentHashMap<>();

    //监听用户注册成功的消息，发送欢迎消息
    @RabbitListener(queues = RabbitConfiguration.QUEUE)
    public void listen(Long userId) {
        log.info("memberService: receive mq user {}", userId);
        welcome(userId);
    }

    @RabbitListener(queues = "#{queue.name}")
    public void memberService(Long userId) {
        log.info("memberService: welcome message sent to new user {} from {}", userId, System.getProperty("server.port"));
    }

    //发送欢迎消息
    public void welcome(Long userId) {
        //去重操作
        if (welcomeStatus.putIfAbsent(userId, true) == null) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("welcome new user {}", userId);
        }
    }
}
