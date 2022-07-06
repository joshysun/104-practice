package com.josh.practice.interfaceAndAbstractClass.abstractClass;

public class SchoolBell extends Bell{
    // 須實作抽象方法
    @Override
    public void ring() {
        System.out.println("學校鐘聲開叫: " + sound);
    }

    public static void main(String[] args) {
        SchoolBell sb = new SchoolBell();
        sb.ring();
        // 可直接用抽象類別定義過的方法，如果要改寫也可以由子類別覆寫
        sb.increaseVolume();
        sb.decreaseVolume();
    }
}
