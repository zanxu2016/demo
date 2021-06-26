package com.example.demo.core.javacore.juc;

import java.util.concurrent.*;

public class CompleteFutureDemo {
    public static void main(String[] args) throws Exception {

        ThreadFactory factory = r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 500, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), factory);

        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("中国石油"), threadPoolExecutor);

//        cfQuery.complete("1");


        CompletableFuture<Double> cfFetch = CompletableFuture.supplyAsync(CompleteFutureDemo::fetchPrice, threadPoolExecutor);

        cfQuery.thenAcceptAsync((a) -> System.out.println("code: " + a +"---"+ Thread.currentThread().getName()));
        cfFetch.thenAcceptAsync((result) -> System.out.println("price: " + result + " >> " + Thread.currentThread().getName()));
        String s = cfQuery.get();
        Double aDouble = cfFetch.get();
        System.out.println(s);
        System.out.println(aDouble);

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
//        Thread.sleep(2000);
        threadPoolExecutor.shutdown();
        System.out.println("=============");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<Void> f =  future.thenAccept(res -> System.out.println(res + ">>" + Thread.currentThread().getName()));
        System.out.println(f.get());
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice() {
        System.out.println("已经拿到价格"+ Thread.currentThread().getName());
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
        }

        return 5 + Math.random() * 20;
    }
}
