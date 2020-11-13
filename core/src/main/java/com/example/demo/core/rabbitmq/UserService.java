package com.example.demo.core.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    public Long register(Long userId) {
        log.info("user register...done!");
        return userId;
    }
}
