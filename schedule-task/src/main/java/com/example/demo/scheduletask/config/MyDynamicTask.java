package com.example.demo.scheduletask.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Slf4j
public class MyDynamicTask implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(Task1(), getTrigger(1));
        scheduledTaskRegistrar.addTriggerTask(Task2(), getTrigger(2));
    }

    //定时任务1
    private Runnable Task1() {
        return () -> log.info("Task1, 时间为:" + new Date(System.currentTimeMillis()));
    }

    //定时任务2

    private Runnable Task2() {
        return () -> {
            // 业务逻辑
            log.info("Task2,时间为:" + new Date(System.currentTimeMillis()));
        };
    }

    private Trigger getTrigger(int taskId) {
        return triggerContext -> {
            // 触发器
            if (StringUtils.isBlank(getCron(taskId))) {
                return null;
            }
            CronTrigger trigger = new CronTrigger(getCron(taskId));
            return trigger.nextExecutionTime(triggerContext);
        };
    }

    // 通过任务名称获取Task,Task是一个对象，有任务ID，任务名称，任务描述，cron等
    public String getCron(int taskId) {
        return TaskEnum.getById(taskId).getCron();
    }


    enum TaskEnum {
        TASK_1(1, "0/10 * * * * *"),
        TASK_2(2, "1/10 * * * * *"),
        TASK_3(3, "2/10 * * * * *"),
        TASK_DEFAULT(999, "5/10 * * * * *"),
        ;

        TaskEnum(int id, String cron) {
            this.id = id;
            this.cron = cron;
        }

        private int id;
        private String cron;

        public int getId() {
            return id;
        }

        public String getCron() {
            return cron;
        }

        public static TaskEnum getById(int id) {
            return Arrays.stream(TaskEnum.values()).filter(taskEnum -> id == taskEnum.getId()).findFirst().orElse(TASK_DEFAULT);
        }
    }
}
