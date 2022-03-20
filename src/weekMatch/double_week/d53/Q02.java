package weekMatch.double_week.d53;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/29 22:33
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {

    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int sum = Integer.MIN_VALUE;

        while (i < j) {
            sum = Math.max(nums[i] + nums[j], sum);
            i++;
            j--;
        }
        return sum;
    }
}
