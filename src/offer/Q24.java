package offer;

import publicUtil.ListNode;

public class Q24 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reverseTail = head.next;
        ListNode reverseHead = reverseList(head.next);
        reverseTail.next = head;
        head.next = null;
        return reverseHead;
    }
}
