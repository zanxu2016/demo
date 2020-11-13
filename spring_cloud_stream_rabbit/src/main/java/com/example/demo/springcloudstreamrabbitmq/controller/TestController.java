package com.example.demo.springcloudstreamrabbitmq.controller;

import com.example.demo.springcloudstreamrabbitmq.binding.TestTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestTopic testTopic;

    /**
     * 消息生产接口
     *
     * @param message
     * @return
     */
    @GetMapping("/sendMessage")
    public String messageWithMQ(@RequestParam String message) {
        log.info("Send: " + message);

//        MessageBuilder<Object> builder = MessageBuilder.withPayload(message);
//        MessageProperties properties = new MessageProperties();
//        properties.setDelay(10_000);
////        properties.setReceivedDelay(5000);
//        Map<String, Object> headers = properties.getHeaders();
//        builder.copyHeaders(headers);
//
//        testTopic.output().send(builder.build());


        testTopic.output().send(MessageBuilder.withPayload(message)
            .setHeader("x-delay", 6000).build());
        return "ok";
    }

}
