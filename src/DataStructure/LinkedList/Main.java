package DataStructure.LinkedList;

import com.kingkong.leetcode.MiddleOfTheLinkedList.Solution;

public class Main {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        Solution solution = new Solution();

        solution.middleNode02(one);
    }
}
