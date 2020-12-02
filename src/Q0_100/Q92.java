package Q0_100;

import publicUtil.ListNode;

public class Q92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode lastNode = null;
        ListNode temp = head;
        for (int i = 0; i < m - 1; i++) {
            lastNode = temp;
            temp = temp.next;
        }

        if (lastNode == null) {
            return reverseList(temp, n - m);
        } else {
            lastNode.next = reverseList(temp, n - m);
            return head;
        }
    }

    public ListNode reverseList(ListNode head, int deep) {
        if (head == null || head.next == null || deep <= 0) return head;

        ListNode reverseTail = head.next;
        ListNode reverseHead = reverseList(head.next, deep - 1);
        head.next = reverseTail.next;
        reverseTail.next = head;
        return reverseHead;
    }
}
