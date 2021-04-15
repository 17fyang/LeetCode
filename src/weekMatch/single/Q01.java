package weekMatch.single;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/5 14:50
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        System.out.println(new Q01().purchasePlans(new int[]{2, 2, 1, 9}, 10));
    }

    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int res = erfenFind(nums, i, target);
            if (res != -1) result = (result + (res - i)) % 1000000007;
        }
        return (int) result;
    }

    private int erfenFind(int[] nums, int left, int target) {
        int right = nums.length - 1;
        int t = target - nums[left];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= t) left = mid;
            else right = mid - 1;
        }

        return nums[left] > t ? -1 : left;
    }
}
