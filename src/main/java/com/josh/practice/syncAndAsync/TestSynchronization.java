package com.josh.practice.syncAndAsync;

public class TestSynchronization {
    public static void main(String[] args) {
        final PrintInt printInt = new PrintInt();

        // 如果把synchronized區塊拿掉直接執行printInt.print()方法的話，物件不會被lock住。
        new Thread(() -> {
            synchronized (PrintInt.class) {
                printInt.print(5);
            }
        }).start();

        new Thread(() -> {
            synchronized (PrintInt.class) {
                printInt.print(100);
            }
        }).start();
    }
}
