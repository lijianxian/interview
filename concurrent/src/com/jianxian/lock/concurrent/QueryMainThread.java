package com.jianxian.lock.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class QueryMainThread {
    /**
     * [6] Monitor Ctrl-Break
     * [5] Attach Listener
     * [4] Signal Dispatcher      // 分发处理发送给JVM信号的线程
     * [3] Finalizer              // 调用对象finalizer方法的线程 : 专门用来收集被finalize()方法的队列
     * [2] Reference Handler      // 清楚Reference的线程 引用
     * [1] main                   // main函数主线程
     */

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
                    getThreadName());
        }
    }
}
