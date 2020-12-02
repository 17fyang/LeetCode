package Q400_500;

import java.util.Arrays;

/**
 * ClassName: Q416
 * Description:
 * date: 2020/10/11 16:01
 *
 * @author :ÎÚÑ»×ø·É»úÙï
 * @version:
 */
public class Q416 {
    public static void main(String[] args) {
        int[] nums = new int[]{14, 9, 8, 4, 3, 2};
        System.out.println(new Q416().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int total = Arrays.stream(nums).sum();
        if (nums.length % 2 != 0) return false;
        if (total % 2 != 0) return false;
        int half = total / 2;
        int left = 0, right = 0;
        total = 0;
        while (right < nums.length) {
            total += nums[right];
            if (total == half) return true;
            else if (total < half) {
                right++;
                continue;
            }
            while (left <= right) {
                if (total == half) return true;
                else if (total < half) return false;
                total -= nums[left];
                left++;
            }
        }
        return false;
    }
}
