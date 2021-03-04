package weekMatch.w229;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/21 10:28
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[] nums = new int[]{-5, -3, -3, -2, 7, 1};
        int[] arr = new int[]{-10, -5, 3, 4, 6};
        System.out.println(new Q03().maximumScore(nums, arr));
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int nLen = multipliers.length;

        int[][] dp = new int[nLen][nLen + 1];

        dp[0][0] = multipliers[0] * nums[nums.length - 1];
        dp[0][1] = multipliers[0] * nums[0];

        for (int i = 1; i < multipliers.length; i++) {
            dp[i][i + 1] = dp[i - 1][i] + multipliers[i] * nums[i];
            dp[i][0] = dp[i - 1][0] + multipliers[i] * nums[nums.length - i];
            for (int j = i; j > 0; j--) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + multipliers[i] * nums[j - 1],
                        dp[i - 1][j] + multipliers[i] * nums[nums.length - j - 1]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }
        return max;
    }
}
