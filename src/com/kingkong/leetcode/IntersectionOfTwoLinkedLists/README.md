# [160. Intersection of Two Linked Lists (Easy)](https://leetcode.com/problems/intersection-of-two-linked-lists/)

## Description


Write a program to find the node at which the intersection of two singly linked lists begins.


## 解法 1
由于两条链表的长度可能不相同; 因此将两条链表交叉相连, 形成长度相同的两条链表,进行遍历判断结点;
时间复杂度: 需要遍历两链表长度和 O(m+n)
空间复杂度: 需要使用两个变量 O(1)

```java
class Solution {
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
}
```

## 解法 2

由于两条链表的长度可能不相同; 计算两条链表的长度差, 对长链表进行一定量的偏移, 使游标处于相对交叉点共同的位置;

同上
时间复杂度: 需要遍历两链表长度和 O(2(m+n))
空间复杂度: 需要使用两个变量 O(1)
```java
class Solution {
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
```
