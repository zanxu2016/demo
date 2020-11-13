package com.example.demo.core.delay_queue.youzan;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class Job {

    Long id;
    Topic topic;
    long delay;
    long timeToRun;
    String msg;
    State state;
    long createTs;


    public enum Topic {
        OFF_HOUSE;
    }

    public enum State {
        INIT, READY, DELAY, RESERVED, DELETED;
    }
}
