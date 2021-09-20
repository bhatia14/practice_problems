package practice;

public class AddTwoNumbers {


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode l2 = new ListNode(9, new ListNode(9));

        addTwoNumbers(l1, l2);
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        addNumbers(l1, l2, 0, result);
        return result;
    }


    static void addNumbers(ListNode l1, ListNode l2, int remainder, ListNode result) {
        if (l1 != null && l2 != null) {
            result.val = l1.val + l2.val + remainder;
        } else if (l1 != null && l2 == null) {
            result.val = l1.val + remainder;
        } else if (l2 != null && l1 == null) {
            result.val = l2.val + remainder;
        }
        int rem = result.val > 9 ? 1 : 0;
        if (result.val > 9) {
            result.val = result.val - 10;
        }


        if ((l1 != null && l1.next != null) && (l2 != null && l2.next != null)) {
            result.next = new ListNode();
            addNumbers(l1.next, l2.next, rem, result.next);
        } else if (l1 != null && l1.next != null) {
            result.next = new ListNode();
            addNumbers(l1.next, null, rem, result.next);
        } else if (l2 != null && l2.next != null) {
            result.next = new ListNode();
            addNumbers(null, l2.next, rem, result.next);
        } else if (rem > 0) {
            result.next = new ListNode(1);
        }

    }
}
