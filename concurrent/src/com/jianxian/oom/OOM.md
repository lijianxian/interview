# 				手写jvm中的各种OOM

## java堆（GC堆）的OOM

java堆出现OOM的情况如下：

​    **堆中没有内存完成实例分配时，并且堆无法再扩展时。将抛出OutOfMemoryError。**

为了让java堆（GC堆）更容易出现OOM，我们需要把JVM的堆内存分配的小一点，需要用到的参数如下：

```java
-Xms20m (JVM初始分配的堆内存)   -Xmx20m(最大可使用内存)
```

如果不配置.会使用IDEA默认配置.24G内存的我跑了5分多钟

### 造成GC堆OOM的代码如下：

​    其核心就是不断的生产对象，并保证已生产对象存活。利用List，维护所有OOMObject对象存活（利用list保存所有OOMObject都有引用），并利用集合自动扩展申请新的内存，直至Java堆剩余空间，不满足新的OOMObject对象所需的空间为止。

#### 使用List引用让GC回收器无法回收信息,最终导致OOM

```java
public class HeapOOM {
    /** * -Xms20m -Xmx20m*/
    // heap : 堆
    static class OOMObject { }
    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
```

## Java虚拟机栈OOM

虚拟机栈理论上有2种异常：

**1.StackOverflowError,线程请求的栈深度大于虚拟机所允许的深度。  **StackOverflowError非常容易出现

**2.OutOfMemoryError栈扩展时申请到不足够的内存。**OutOfMemoryError从未出现过

下面仅介绍如何生成StackOverflowError。

-Xss128k(设置每个线程的堆栈大小 为128K)

```java
public class JavaVMStackSOF {
    /**     * -Xss128k     */
    //    stack : 栈
    //    leak : 泄露
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        sof.stackLeak();
    }
}
```

