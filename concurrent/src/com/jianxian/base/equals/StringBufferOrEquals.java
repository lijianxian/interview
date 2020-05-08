package com.jianxian.base.equals;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Set;

public class StringBufferOrEquals {
    public static void main(String[] args) {
        /**
         * 注释 1 打印为 false，主要考察 String 的 equals 方法，
         * String 源码中 equals 方法有对参数进行 instance of String 判断语句，StringBuffer 的祖先为 CharSequence，所以不相等；
         * 注释 2 打印为 false，因为 StringBuffer 没有重写 Object 的 equals 方法，所以 Object 的 equals 方法实现是 == 判断，故为 false；
         * 注释 3 打印为 true，因为 Object 的 toString 方法返回为 String 类型，String 重写了 equals 方法实现为值比较。
         */
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));    //1,false

        StringBuffer s3 = new StringBuffer("abc");
        System.out.println(s3.equals("abc"));    //2,false
        System.out.println(s3.toString().equals("abc"));    //3,true

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();



        AbstractMap abstractMap = new AbstractMap() {
            @Override
            public Set<Entry> entrySet() {
                return null;
            }
        };


    }

}
