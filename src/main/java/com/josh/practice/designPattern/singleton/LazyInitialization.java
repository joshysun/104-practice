package com.josh.practice.designPattern.singleton;

/**
 * Lazy Initialization (懶初始化)
 * 在對外的public方法中生成物件，需要加一個是否為空的判斷。
 * 在單執行緒的環境下可以正常工作。
 */
public class LazyInitialization {
    private static LazyInitialization instance;

    private LazyInitialization() {
    }

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}