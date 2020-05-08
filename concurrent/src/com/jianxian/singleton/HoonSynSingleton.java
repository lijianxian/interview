package com.jianxian.singleton;

public class HoonSynSingleton {
    // 这个代码也有问题
    private static HoonSynSingleton instance = null;

    private HoonSynSingleton() {
    }

    public synchronized static HoonSynSingleton getInstance() {
        if (null == instance)
            instance = new HoonSynSingleton();
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(HoonSynSingleton.getInstance());
            }).start();
        }
    }
}
