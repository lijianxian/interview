package com.jianxian.singleton;

public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}

//holder
//枚举
//DCL
