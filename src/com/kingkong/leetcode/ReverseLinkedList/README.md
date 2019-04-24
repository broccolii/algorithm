# [206. Reverse Linked List (Easy)](https://leetcode.com/problems/reverse-linked-list/)

## Description

Reverse a singly linked list.

**Example:**

```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```


## 解法 1

迭代解法: 增加一个中间变量 prev 进行反转; 
时间复杂度: O(n)
空间复杂度: O(1)

```java
class Solution {
     public ListNode reverse01(ListNode head) {
         ListNode prev = null;
    
         while (head != null) {
             ListNode next = head.next;
    
             head.next = prev;
             prev = head;
             head = next;
         }
         return prev;
     }
}
```

## 解法 2

递归解法: 在调用栈回溯之前:
所有结点的 next 都被赋值为 null

```$xslt
1      2      3      4
|      |      |      |
null   null  null   null
```
再依次添加反向的引用

时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public ListNode reverse02(ListNode head) {
    
        if (head == null || head.next == null) {
            return head;
        }
            
        ListNode next = head.next;
        head.next = null;
    
        ListNode prev = reverse02(next);
    
        next.next = head;
            
        return prev;
    }
}
```
