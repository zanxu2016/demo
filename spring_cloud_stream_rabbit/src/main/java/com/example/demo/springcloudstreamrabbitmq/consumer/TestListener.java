package com.example.demo.springcloudstreamrabbitmq.consumer;

import com.example.demo.springcloudstreamrabbitmq.binding.TestTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费逻辑
 */
@Slf4j
@Component
public class TestListener {

    @StreamListener(TestTopic.INPUT)
    public void receive(String payload) {
        log.info("Received: " + payload);
    }

}
