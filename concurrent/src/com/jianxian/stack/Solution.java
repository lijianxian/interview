package com.jianxian.stack;

public class Solution {

    public static void main(String[] args) {


    }


    public ListNode middleNode(ListNode head) {
        // slow : 慢指针
        // fast : 慢指针
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;


    }
}
