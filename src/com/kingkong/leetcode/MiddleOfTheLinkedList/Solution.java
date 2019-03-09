package com.kingkong.leetcode.MiddleOfTheLinkedList;

import DataStructure.LinkedList.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode01(ListNode head) {

        if (head == null) {
            return head;
        }

        int length = 0;

        ListNode tmp = head;

        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }

        tmp = head;
        for (int i = 0; i < (length / 2); i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public ListNode middleNode02(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }
}
