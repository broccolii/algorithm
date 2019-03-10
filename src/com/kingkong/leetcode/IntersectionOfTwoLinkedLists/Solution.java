package com.kingkong.leetcode.IntersectionOfTwoLinkedLists;

public class Solution {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode01(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode cursorA = headA;
        ListNode cursorB = headB;

        while (cursorA != cursorB) {
            if (cursorA.next != null) {
                cursorA = cursorA.next;
            } else {
                cursorA = headB;
            }

            if (cursorB.next != null) {
                cursorB = cursorB.next;
            } else {
                cursorB = headA;
            }
        }

        return cursorA;
    }

    public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        // 获取链表长度
        int lenA = 0, lenB = 0;
        for (ListNode i = headA; i != null; i = i.next) {
            lenA ++;
        }

        for (ListNode i = headB; i != null; i = i.next) {
            lenB ++;
        }

        // 将长链进行一定量的偏移
        ListNode cursorA = headA, cursorB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                cursorA = cursorA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                cursorB = cursorB.next;
            }
        }

        while (cursorA != cursorB) {
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }

        return cursorA;
    }
}
