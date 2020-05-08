package com.jianxian.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 重复锁保证数据原子性
public class reentrantLockIsAtomicityTest {
    public  int inc = 0;
    Lock lock = new ReentrantLock();

    public  void increase() {
        lock.lock();
        try {
            inc++;
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final reentrantLockIsAtomicityTest reentrantLockIsAtomicityTest = new reentrantLockIsAtomicityTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        reentrantLockIsAtomicityTest.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(reentrantLockIsAtomicityTest.inc);
    }
}