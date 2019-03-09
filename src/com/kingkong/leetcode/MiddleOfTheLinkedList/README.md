# [876. Middle of the Linked List (Easy)](https://leetcode.com/problems/middle-of-the-linked-list/)

## Description


Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

**Example:**

```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```


## 解法 1

暴力解法; 遍历链表获取长度, 再遍历一半长度;
```java
class Solution {
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
}


```

## 解法 2

使用快慢指针的方法, 当快指针以每次两步到达链表尾部时, 慢指针刚好到达链表中间;
```java
class Solution {
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
```
