package com.example.demo.core.delay_queue.youzan;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class JobPool {
    private Map<Long, Job> jobMap = new HashMap<>();

    private JobPool(){}

    public static JobPool create() {
        return new JobPool();
    }

    public void put(Job job) {
        Objects.requireNonNull(job);
        Objects.requireNonNull(job.getId());

        if (Objects.isNull(jobMap)) {
            jobMap = new HashMap<>();
        }
        jobMap.put(job.getId(), job);
    }

    public Job remove(Job job) {
        Objects.requireNonNull(job);
        Objects.requireNonNull(job.getId());

        if (Objects.isNull(jobMap)) {
            throw new UnsupportedOperationException("no job left in pool");
        }
        return jobMap.remove(job.getId());
    }

    public Job get(Long id) {
        return jobMap.get(id);
    }
}
