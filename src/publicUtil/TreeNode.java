package publicUtil;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static void output(TreeNode head) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(head);
        while (stack.isEmpty()) {
            int length = stack.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = stack.pollLast();
                System.out.print(node.val + " ");
                stack.add(node.left);
                stack.add(node.right);
            }
            System.out.println();
        }

    }
}
