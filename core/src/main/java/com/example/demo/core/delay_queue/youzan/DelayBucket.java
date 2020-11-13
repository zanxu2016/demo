package com.example.demo.core.delay_queue.youzan;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

@Data
public class DelayBucket {

    private Deque<Item> jobQueue;

    private DelayBucket() {
    }

    public static DelayBucket create() {
        return new DelayBucket();
    }

    public void push(Item item) {
        Objects.requireNonNull(item);
        if (Objects.isNull(jobQueue)) {
            jobQueue = new ArrayDeque<>();
        }
        jobQueue.push(item);
    }

    public Item pop() {
        if (Objects.isNull(jobQueue) || jobQueue.size() <= 0) {
            throw new UnsupportedOperationException("no id left in bucket");
        }

        return jobQueue.pop();
    }

    public Item peek() {
        if (Objects.isNull(jobQueue) || jobQueue.size() <= 0) {
            return null;
        }

        return jobQueue.peek();
    }

    @Data
    @AllArgsConstructor
    public static class Item {
        private Long jobId;
        private long absoluteTs;
    }
}
