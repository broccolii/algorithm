# [28. Implement strStr() (Easy)](https://leetcode.com/problems/implement-strstr/)

## Description
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
```
Input: haystack = "hello", needle = "ll"
Output: 2
```

## 解法 1
分别使用两个游标分别对应子串开头以后子串一次匹配的游标

时间复杂度: O((n-m+1)*m)
空间复杂度: O(1)

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
