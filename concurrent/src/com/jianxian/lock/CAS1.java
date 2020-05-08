package com.jianxian.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS1 {
    private static volatile int m = 0;


    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void incrrase1() {
        m++;
    }
    public static void incrrase2() {
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads1 = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads1[i] = new Thread(() -> {
                CAS1.incrrase1();
            });
            threads1[i].start();
            threads1[i].join();
        }
        System.out.println("incrrase1 : " + m);

        Thread[] threads2 = new Thread[20];

        for (int i = 0; i < 20; i++) {
            threads2[i] = new Thread(() -> {
                CAS1.incrrase2();
            });
            threads2[i].start();
            threads2[i].join();
        }
        System.out.println("incrrase2 : " + atomicInteger.get());

    }
}