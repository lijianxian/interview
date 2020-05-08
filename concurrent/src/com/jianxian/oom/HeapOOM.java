package com.jianxian.oom;

import java.util.ArrayList;

public class HeapOOM {
    /**
     * -Xms20m -Xmx20m
     */
    // heap : 堆
    static class OOMObject { }
    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
