package Q100_200;

import publicUtil.ListNode;

public class Q148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode low = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        ListNode secondHead = low.next;
        low.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);

        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        temp.next = left == null ? right : left;
        return result.next;
    }
}
