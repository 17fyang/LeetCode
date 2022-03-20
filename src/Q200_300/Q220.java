package Q200_300;

import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/17 13:30
 * @Description:
 */
public class Q220 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2147483648, 2147483647};
        System.out.println(new Q220().containsNearbyAlmostDuplicate(arr, 1, 1));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0 || nums.length < 1) return false;
        TreeSet<PerNode> set = new TreeSet<>((n1, n2) -> {
            if (n1.val != n2.val) return n1.val < n2.val ? -1 : 1;
            return n1.index - n2.index;
        });

        for (int i = 1; i <= k; i++) {
            if (i >= nums.length) break;
            set.add(new PerNode(nums[i], i));
        }

        for (int i = 0; i < nums.length; i++) {
            long max = (long) nums[i] + t;
            long min = (long) nums[i] - t;


            PerNode first = set.ceiling(new PerNode(min, 0));
            if (first != null && first.val <= max) return true;

            if (i - k >= 0) set.remove(new PerNode(nums[i - k], i - k));
            set.add(new PerNode(nums[i], i));
            if (i < nums.length - 1) set.remove(new PerNode(nums[i + 1], i + 1));
            if (i + k + 1 < nums.length) set.add(new PerNode(nums[i + k + 1], i + k + 1));
        }

        return false;
    }

    static class PerNode {
        long val;
        int index;

        public PerNode(long val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
