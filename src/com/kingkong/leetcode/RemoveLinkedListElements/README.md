# [203. Remove Linked List Elements (Easy)](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## Description


Remove all elements from a linked list of integers that have value val.

**Example:**

```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```


## 解法 1

首先需要处理头结点,需要引入 dummy 结点, 依次判断如果相等则删除`cursor.next = cursor.next.next;`,否则将游标后移`cursor = cursor.next;`;
时间复杂度: O(n)
空间复杂度: O(1)

```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cursor = dummy;

        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return dummy.next;
    }
}
```
