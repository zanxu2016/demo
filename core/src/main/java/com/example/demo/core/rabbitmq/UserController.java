package com.example.demo.core.rabbitmq;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@RestController
@Slf4j
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RabbitTemplate rabbitTemplate;
    private final AmqpTemplate amqpTemplate;

    @GetMapping("register")
    public void register() {
        //模拟10个用户注册
        IntStream.rangeClosed(1, 10).forEach(i -> {
            //落库
            Long userId = userService.register(randomUserId());
            //模拟50%的消息可能发送失败
            if (ThreadLocalRandom.current().nextInt(10) % 2 == 0) {
                //通过RabbitMQ发送消息
                sendMsg(userId);
                log.info("sent mq user {}", userId);
            }
        });
    }

    private static Long randomUserId() {
        return ThreadLocalRandom.current().nextLong(10000);
    }

    private void sendMsg(Long userId) {
        rabbitTemplate.convertAndSend(RabbitConfiguration.EXCHANGE, RabbitConfiguration.ROUTING_KEY, userId);
    }
}
