package com.jianxian.oom;

import java.util.ArrayList;

public class RuntimeConstantPoolOOM {
    /**
     * -XX:PermSize=10M -XX:MaxPermSize=10M -Xmx15M
     * @param args
     */
    public static void main(String[] args) {
        // 使用List保持着常量池的引用，避免Full GC回收常量池
        ArrayList<String> list = new ArrayList<>();
        // 10MB的PermSize在Integer 范围内足够产生OOM了
        int i= 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
