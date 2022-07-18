package com.josh.practice.syncAndAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用執行緒池實現非同步執行
 */
public class TestAsync {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主執行緒 =====> 開始 =====> " + System.currentTimeMillis());


        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            System.out.println("非同步執行緒 =====> 開始 =====> " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("非同步執行緒 =====> 結束 =====> " + System.currentTimeMillis());
        });

        Thread.sleep(2000);
        System.out.println("主執行緒 =====> 結束 =====> " + System.currentTimeMillis());
        executor.shutdown();
    }
}
