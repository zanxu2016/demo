package com.example.demo.core.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public final static String EXCHANGE = "my-exchange";
    public final static String ROUTING_KEY = "my-route-key";
    public final static String QUEUE = "my-queue";


    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public Declarables declarable() {
        DirectExchange exchange = new DirectExchange(EXCHANGE);
        return new Declarables(queue(), exchange, BindingBuilder.bind(queue()).to(exchange).with(ROUTING_KEY));
    }
}
