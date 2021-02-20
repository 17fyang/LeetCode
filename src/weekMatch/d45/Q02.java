package weekMatch.d45;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/6 22:18
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        int[] arr = new int[]{-3, -5, -3, -2, -6, 3, 10, -10, -8, -3, 0, 10, 3, -5, 8, 7, -9, -9, 5, -8};
        System.out.println(new Q02().maxAbsoluteSum(arr));
        System.out.println(new Q02().solution2(arr));
    }

    public int maxAbsoluteSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sum.length; i++) max = Math.max(sum[i], max);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) min = Math.min(sum[i], min);

        return Math.max(max - min, Math.max(max, Math.abs(min)));
    }

    private int solution2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int add = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                add += nums[j];
                if (Math.abs(add) > max) max = Math.abs(add);
            }
        }
        return max;
    }
}
