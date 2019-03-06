package DataStructure.LinkedList;

public class Main {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        ReverseLinkedList solution = new ReverseLinkedList();

        solution.reverse02(one);
    }
}
