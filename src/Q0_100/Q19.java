package Q0_100;

import publicUtil.ListNode;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/15 13:23
 * @Description:
 */
public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int len = recursion(head, n);
        if (len == n) return head.next;
        return head;
    }

    private int recursion(ListNode node, int target) {
        if (node == null) return 0;
        int locate = recursion(node.next, target) + 1;
        if (locate == target + 1) {
            node.next = node.next.next;
        }
        return locate;
    }
}
