# [237. Delete Node in a Linked List (Easy)](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## Description


Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

**Example:**

```
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```


## 解法 1

删除指定某个结点, 因为不可知上一个元素;因此不能直接使用 `pre.next = node.next.next` 的做法; 题目中给定了两个限定条件: 即不删除最后一个结点和链表中至少两个结点; 可以通过结点前移来处理;
时间复杂度: O(1)
空间复杂度: O(1)

```java
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```
