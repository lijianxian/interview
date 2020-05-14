package com.jianxian.gc;

public class ReferenceCountingGC {
    private ReferenceCountingGC instance = null;
    private static final int _1m = 1024*1024;
    //只是为了占点内存
    private byte[] bigSize = new byte[2*_1m];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}

