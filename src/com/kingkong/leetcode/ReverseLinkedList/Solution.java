package DataStructure.LinkedList;

public class ReverseLinkedList {

    // 迭代实现
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

    // 递归实现
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
