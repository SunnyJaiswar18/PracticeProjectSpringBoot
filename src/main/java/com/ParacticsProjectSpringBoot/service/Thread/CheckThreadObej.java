package com.ParacticsProjectSpringBoot.service.Thread;

public class CheckThreadObej extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield();
        }
    }
    public static void main(String[] args) {
        CheckThreadObej t1 = new CheckThreadObej();
        CheckThreadObej t2 = new CheckThreadObej();
        t1.start();
        t2.start();
    }
}