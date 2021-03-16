package Q1300_1400;

import publicUtil.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/10 13:59
 * @Description:
 */
public class Q1372 {
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> leftMap = new HashMap<>();
        Map<TreeNode, Integer> rightMap = new HashMap<>();

        dfs(leftMap, rightMap, root);

        int max = Integer.MIN_VALUE;
        for (int i : leftMap.values()) max = Math.max(i, max);
        for (int i : rightMap.values()) max = Math.max(i, max);
        return max + 1;

    }

    private void dfs(Map<TreeNode, Integer> left, Map<TreeNode, Integer> right, TreeNode local) {

        if (local.left != null) {
            dfs(left, right, local.left);
            left.put(local, right.getOrDefault(local.left, 0) + 1);
        }

        if (local.right != null) {
            dfs(left, right, local.right);
            right.put(local, left.getOrDefault(local.right, 0) + 1);
        }
    }

}
