package com.example.demo.scheduletask.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class Timer {

    @Scheduled(fixedRate = 2000)
    public void timer() {
        log.info("current time: {}", new Date());
    }
}
