package weekMatch.team;

import publicUtil.TreeNode;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/10 14:54
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {

    }

    public int maxValue(TreeNode root, int k) {
        int[] arr = dp(root, k);
        return Arrays.stream(arr).max().getAsInt();
    }

    private int[] dp(TreeNode node, int k) {
        if (node.left == null && node.right == null) {
            int[] t = new int[k + 1];
            t[1] = node.val;
            return t;
        }

        int[] left = null;
        if (node.left != null) left = dp(node.left, k);

        int[] right = null;
        if (node.right != null) right = dp(node.right, k);

        int[] arr = new int[k + 1];
        int[] single = null;
        if (left == null) single = right;
        else if (right == null) single = left;
        if (single != null) {
            arr[0] = Arrays.stream(single).max().getAsInt();
            for (int i = 1; i <= k; i++) arr[i] = single[i - 1] + node.val;

            return arr;
        } else {
            int leftMax = Arrays.stream(left).max().getAsInt();
            int rightMax = Arrays.stream(right).max().getAsInt();
            arr[0] = leftMax + rightMax;
            arr[1] = left[0] + right[0] + node.val;

            for (int i = 2; i <= k; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < i; j++) max = Math.max(max, left[j] + right[i - j - 1]);
                arr[i] = max + node.val;
            }
            return arr;
        }
    }
}
