package com.jianxian.singleton;

public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == instance)
            synchronized (Singleton.class) {
                if (null == instance)
                    if (null == instance)
                        instance = new Singleton();
            }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getInstance());
            }).start();
        }
    }

}
