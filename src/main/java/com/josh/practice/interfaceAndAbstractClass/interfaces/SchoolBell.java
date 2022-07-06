package com.josh.practice.interfaceAndAbstractClass.interfaces;

public class SchoolBell implements Bell {
    // 需實作介面中的每個方法
    @Override
    public void ring() {
        System.out.println("叮叮噹");
    }

    @Override
    public void increaseVolume() {
        System.out.println("大聲點我聽不見");
    }

    @Override
    public void decreaseVolume() {
        System.out.println("小聲點拜託");
    }

    public static void main(String[] args) {
        SchoolBell sb = new SchoolBell();
        sb.ring();
        sb.increaseVolume();
        sb.decreaseVolume();
    }
}
