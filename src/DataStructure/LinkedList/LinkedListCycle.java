package DataStructure.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
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

    public boolean hasCycle02(ListNode head) {
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
}
