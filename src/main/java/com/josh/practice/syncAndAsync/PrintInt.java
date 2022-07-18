package com.josh.practice.syncAndAsync;

public class PrintInt {
    public void print(int n) {
        for (int i = 1; i < 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.print(e.getMessage());
            }
        }
    }
}
