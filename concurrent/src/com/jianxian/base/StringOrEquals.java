package com.jianxian.base;

public class StringOrEquals {

    /**
     * == 在比较基本数据类型时比较的是值，而用==号比较两个对象时比较的是两个对象的地址值：
     * （== 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，
     * 即是否是指相同一个对象。比较的是真正意义上的指针操作）
     */
    public static void main(String[] args) {

        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true 8             System.out.println("aa==bb");
            if (a == b) // false，非同一对象
                System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
        /**
         * String s = "abce" 是一种非常特殊的形式,和new 有本质的区别。它是java中唯一不需要new 就可以产生对象的途径。
         * 以String s="abce";形式赋值在java中叫直接量,它是在常量池中而不是象new一样放在压缩堆中。
         * 这种形式的字符串，在JVM内部发生字符串拘留，即当声明这样的一个字符串后，
         * JVM会在常量池中先查找有有没有一个值为"abcd"的对象,如果有,就会把它赋给当前引用.
         * 即原来那个引用和现在这个引用指点向了同一对象,如果没有,则在常量池中新创建一个"abcd",下一次如果有String s1 = "abcd";
         * 又会将s1指向"abcd"这个对象,即以这形式声明的字符串,只要值相等,任何多个引用都指向同一对象.
         */

        /** String equals 源码
         *  1.先是引用地址值进行对比
         *  2.比对两对象的长度
         *  3.for减循环对比每个char的值
         *  public boolean equals(Object anObject) {
         *         if (this == anObject) {
         *             return true;
         *         }
         *         if (anObject instanceof String) {
         *             String anotherString = (String)anObject;
         *             int n = value.length;
         *             if (n == anotherString.value.length) {
         *                 char v1[] = value;
         *                 char v2[] = anotherString.value;
         *                 int i = 0;
         *                 while (n-- != 0) {
         *                     if (v1[i] != v2[i])
         *                         return false;
         *                     i++;
         *                 }
         *                 return true;
         *             }
         *         }
         *         return false;
         *     }
         */
    }
}
