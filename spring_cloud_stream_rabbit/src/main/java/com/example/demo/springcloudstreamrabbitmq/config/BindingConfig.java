package com.example.demo.springcloudstreamrabbitmq.config;

import com.example.demo.springcloudstreamrabbitmq.binding.TestTopic;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(TestTopic.class)
public class BindingConfig {
}
