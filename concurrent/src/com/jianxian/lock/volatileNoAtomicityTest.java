package com.jianxian.lock;

// volatile 只保证数据可见性,不保证数据原子性
public class volatileNoAtomicityTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final volatileNoAtomicityTest volatileNoAtomicityTest = new volatileNoAtomicityTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        volatileNoAtomicityTest.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(volatileNoAtomicityTest.inc);
    }
}