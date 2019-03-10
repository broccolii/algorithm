# [234. Palindrome Linked List (Easy)](https://leetcode.com/problems/intersection-of-two-linked-lists/)

## Description


Given a singly linked list, determine if it is a palindrome.

**Example:**

```
Input: 1->2
Output: false

Input: 1->2->2->1
Output: true
```

## 解法 1
反转一半长度的链表, 通过遍历两个链表进行判断是否各个元素是否相等;
```java
class Solution {
    public boolean isPalindrome01(ListNode head) {
        int len = 0;
        for (ListNode i = head; i != null; i = i.next, len++);

        // 反转一半长度的链表
        ListNode pre = null;
        ListNode current = head;

        for (int i = 0; i < len / 2; i++) {
            // 保存 后续链表
            ListNode next = current.next;

            current.next = pre;

            // 游标后移
            pre = current;
            current = current.next;
        }

        // 判断 奇偶
        if (len % 2 == 1) {
            current = current.next;
        }

        while (current != null) {
            if (current.val != pre.val) {
                return false;
            }
            current = current.next;
            pre = pre.next;
        }
        return true;
    }
}
```

## 解法 2

将链表压入栈中, 依次 pop 判断结点元素是否相等;

```java
class Solution {
    public boolean isPalindrome02(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode i = head; i != null; i = i.next) {
            stack.push(i.val);
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
```
