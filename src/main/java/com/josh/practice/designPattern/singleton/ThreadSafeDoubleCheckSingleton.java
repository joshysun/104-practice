package com.josh.practice.designPattern.singleton;

/**
 * Thread Safe Singleton (執行緒安全式單例)
 * 在public方法裡增加synchronized修飾符，這樣一次就只有一個執行緒可以訪問該方法。
 */
public class ThreadSafeDoubleCheckSingleton {
    private static ThreadSafeDoubleCheckSingleton instance;

    private ThreadSafeDoubleCheckSingleton() {
    }

    public static ThreadSafeDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}