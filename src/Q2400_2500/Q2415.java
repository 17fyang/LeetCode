package Q2400_2500;

import publicUtil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2023/3/16 23:44
 */
public class Q2415 {
    public static void main(String[] args) {

    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> evenList = new LinkedList<>();
        evenList.add(root);
        boolean isOdd = false;
        while (!evenList.isEmpty()) {
            if (isOdd) {
                Stack<Integer> oddStack = new Stack<>();
                for (TreeNode node : evenList) {
                    oddStack.add(node.val);
                }

                int i = evenList.size();
                while (i-- > 0) {
                    TreeNode node = evenList.poll();
                    node.val = oddStack.pop();
                    if (node.left != null) {
                        evenList.add(node.left);
                        evenList.add(node.right);
                    }
                }
            } else {
                int i = evenList.size();
                while (i-- > 0) {
                    TreeNode node = evenList.poll();
                    if (node.left != null) {
                        evenList.add(node.left);
                        evenList.add(node.right);
                    }
                }
            }

            isOdd = !isOdd;
        }
        return root;
    }
}
