package com.jianxian.base;

public class IntegerOrEquals {
    public static void main(String[] args) {
        /**
         * 好了，相信你一定耐心地看到了这里，我们来总结一下
         * == 和equals()两种比较方法，在使用时要注意：
         * 1、如果测试两个简单类型的数值是否相等，则一定要用“==”来比较；
         * 2、如果要比较两个引用变量对象的值是否相等，则要用对象的equals()方法进行比较；
         * 3、如果需要比较两个引用变量是否指向同一对象，则使用“==”来进行比较；
         * 还有，对于自定义的类，应该根据情况覆盖其父类或Object类中的equals()方法，否则默认的equals()方法功能与“==”相同。
         */
        //简单类型比较
        int a = 100;
        int b = 100;
        System.out.println("a == b?" + (a == b));
        //引用类型比较
        Integer c = new Integer(100);
        Integer d = new Integer(100);
        System.out.println("c == d?" + (c == d));
        System.out.println("c == d?" + (c.equals(d)));

        /** Integer equals 源码 -> 拿到两个对象的值进行比较
         *  public boolean equals(Object obj) {
         *             if (obj instanceof Integer) {
         *                 return value == ((Integer)obj).intValue();
         *             }
         *             return false;
         *         }
         */
        /** Integer hashCode 源码 -> 直接返回Integer数值
         *  public int hashCode() {
         *         return Integer.hashCode(value);
         *     }
         *  public static int hashCode(int value) {
         *         return value;
         *     }
         */

    }

}
