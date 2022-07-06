package com.josh.practice.interfaceAndAbstractClass.abstractClass;

public abstract class Bell {
    protected String sound;

    //constructor
    public Bell() {
        this.sound = "叮叮噹";
    }

    abstract public void ring();

    // 抽象類別裡可定義一般方法，也可以實作
    public void increaseVolume() {
        System.out.println("大聲點我聽不見");
    }

    public void decreaseVolume() {
        System.out.println("小聲點拜託");
    }
}
