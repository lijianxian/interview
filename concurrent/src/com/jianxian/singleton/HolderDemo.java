package com.jianxian.singleton;

public class HolderDemo {
    private HolderDemo() {

    }

    private static class Holder {
        private static HolderDemo instance = new HolderDemo();
    }

    //懒加载
    //synchronized
    //<init>
    public static HolderDemo getInstance() {
        return Holder.instance;
    }

    //广泛的一种单例模式
}
