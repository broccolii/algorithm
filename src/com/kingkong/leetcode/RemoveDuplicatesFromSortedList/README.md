# [83. Remove Duplicates from Sorted List (Easy)](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## Description


Given a sorted linked list, delete all duplicates such that each element appear only once.

**Example:**

```
Input: 1->1->2
Output: 1->2
```


## 解法 1

因为题目中链表是有序的,所以依次比较相邻的两个元素即可;
```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
```
