package offer;

import publicUtil.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/20 23:28
 */
public class Q32 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();

                result.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int val : result) {
            arr[i++] = val;
        }
        return arr;
    }
}
