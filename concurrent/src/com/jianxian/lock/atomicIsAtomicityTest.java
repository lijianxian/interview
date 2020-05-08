package com.jianxian.lock;

import java.util.concurrent.atomic.AtomicInteger;

// 原子包装类实现数据的原子性;Atomic原理是使用CAS
public class atomicIsAtomicityTest {
    public  AtomicInteger inc = new AtomicInteger();

    public  void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final atomicIsAtomicityTest test = new atomicIsAtomicityTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
