# [141. Linked List Cycle (Easy)](https://leetcode.com/problems/linked-list-cycle/)

## Description


iven a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

**Example:**

```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```


## 解法 1

使用快慢指针的方法, 遍历链表当出现 `fastNode == slowNode` 的时候则链表出现环;
```java
class Solution {
    public boolean hasCycle01(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while (fastNode != null && fastNode.next != null) {
            if (fastNode == slowNode) {
                return true;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;
    }
}


```

## 解法 2

用哈希表存储已经遍历的结点, 当出现重复结点则表示链表有环;
```java
class Solution {
    Set<ListNode> nodeSet = new HashSet<ListNode>();

    while (head != null) {
        if (nodeSet.contains(head)) {
            return true;
        }
        nodeSet.add(head);
        head = head.next;
    }
    return false;
}
```
