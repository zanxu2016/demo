package com.example.demo.core.delay_queue.youzan;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

@Data
public class ReadyQueue {

    private Deque<Job> jobQueue;

    private ReadyQueue() {
    }

    public static ReadyQueue create() {
        return new ReadyQueue();
    }

    public void push(Job job) {
        Objects.requireNonNull(job);
        if (Objects.isNull(jobQueue)) {
            jobQueue = new ArrayDeque<>();
        }
        jobQueue.push(job);
    }

    public Job pop() {
        if (Objects.isNull(jobQueue) || jobQueue.size() <= 0) {
            throw new UnsupportedOperationException("no job left in queue");
        }

        return jobQueue.pop();
    }

    public Job peek() {
        if (Objects.isNull(jobQueue) || jobQueue.size() <= 0) {
            throw new UnsupportedOperationException("no job left in queue");
        }

        return jobQueue.peek();
    }

    public boolean isEmpty() {
        return Objects.isNull(jobQueue) || jobQueue.isEmpty();
    }
}
