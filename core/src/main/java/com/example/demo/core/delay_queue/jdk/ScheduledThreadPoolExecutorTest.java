package com.example.demo.core.delay_queue.jdk;

import java.util.Calendar;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        //
        ScheduledThreadPoolExecutor schedulePool = new ScheduledThreadPoolExecutor(4);

//      周期任务
//      从上一周期的任务的开始时间到当前周期的任务开始时间的间隔
//      任务的执行时间 > period参数：时间间隔是任务的执行时间。
//      任务的执行时间 < period参数：时间间隔是period参数。
        ScheduledFuture<?> scheduledFuture = schedulePool.scheduleAtFixedRate(new MyRunnable(), 50, 5000, TimeUnit.MILLISECONDS);


//      取消该任务
        Thread.sleep(20000);
        scheduledFuture.cancel(true);


//      延时任务
//      从上一周期的任务的执行结束时间到当前周期的任务开始时间的间隔，固定延迟时间为delay参数，与任务执行时间无关。
//      schedulePool.scheduleWithFixedDelay(new MyRunnable(), 50, 1000, TimeUnit.MILLISECONDS);


    }

    static class MyRunnable implements Runnable {

        int period = 1;

        @Override
        public void run() {
            //为周期任务捕获异常，避免异常影响下一周期的任务执行
            try {
                System.out.println("---------------第 " + period + " 周期-------------");
                System.out.println("begin = " + System.currentTimeMillis() / 1000);//秒
                //任务执行时间
                Thread.sleep(2000);
                System.out.println("end   = " + System.currentTimeMillis() / 1000);
                period++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 计算初始的延迟毫秒数
     *
     * @return
     */
    public static long getDelayMillis() {
        int dayOfHour = 0; // 24h 制
        int minute = 0;
        int second = 0;
        long delay;  //首次执行任务的延迟
        Calendar c = Calendar.getInstance();
        long currentTime = c.getTimeInMillis();
        c.set(Calendar.HOUR_OF_DAY, dayOfHour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        long executeTime = c.getTimeInMillis();
        delay = executeTime - currentTime < 0 ? (executeTime + 24 * 60 * 60 * 1000 - currentTime)
                : (executeTime - currentTime);
        System.out.println("DelayTimeInMillis =" + delay);
        return delay;
    }
}
