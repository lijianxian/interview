package com.jianxian.oom;

public class JavaVMStackSOF {
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
