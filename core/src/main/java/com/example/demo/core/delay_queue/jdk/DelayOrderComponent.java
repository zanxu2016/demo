package com.example.demo.core.delay_queue.jdk;

import com.example.demo.core.tools.date.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
@Lazy(false)
@RequiredArgsConstructor
@Slf4j
public class DelayOrderComponent {

    private static DelayQueue<OrderMessage> delayQueue = new DelayQueue<>();

    @PostConstruct
    public void init() {
        // 初始化时加载数据库中需处理超时的订单
        List<Long> orderList = LongStream.range(1000, 10000).boxed().collect(Collectors.toList());
        for (Long orderId : orderList) {
            OrderMessage orderMessage = new OrderMessage(String.valueOf(orderId), DateUtil.nowDateTimeToStr());
            this.addToOrderDelayQueue(orderMessage);
        }

        // 启动一个线程，去取延迟消息
        Executors.newSingleThreadExecutor().execute(() -> {
            OrderMessage message = null;
            while (true) {
                try {
                    message = delayQueue.take();
                    //处理超时订单
                    log.info("handle delay order msg: {}", message);

                    removeToOrderDelayQueue(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 加入延迟消息队列
     **/
    private boolean addToOrderDelayQueue(OrderMessage orderMessage) {
        return delayQueue.add(orderMessage);
    }


    /**
     * 从延迟队列中移除
     **/
    private void removeToOrderDelayQueue(OrderMessage orderMessage) {
        if (Objects.isNull(orderMessage)) {
            return;
        }
        for (Iterator<OrderMessage> iterator = delayQueue.iterator(); iterator.hasNext(); ) {
            OrderMessage queue = iterator.next();
            if (orderMessage.getOrderId().equals(queue.getOrderId())) {
                delayQueue.remove(queue);
            }
        }
    }

}
