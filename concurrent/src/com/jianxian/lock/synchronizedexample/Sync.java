package com.jianxian.lock.synchronizedexample;

public class Sync {

    public void test() {
        synchronized (this) {
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}
