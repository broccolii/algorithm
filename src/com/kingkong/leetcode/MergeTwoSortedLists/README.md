# [21. Merge Two Sorted Lists (Easy)](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## Description


Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```


## 解法 1
通过依次比较 `l1`, `l2` 两个链表中的元素, 拼接在 dummy 结点后; 当走到起其中一个链表的尾结点, 则将另一个结点直接拼至结尾;

时间复杂度: 需要遍历两个链表 O(n)
空间复杂度: 需要一个辅助的 dummy 结点 O(1)

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
```
