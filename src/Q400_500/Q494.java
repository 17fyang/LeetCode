package Q400_500;

import publicUtil.DataUtil;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/12 15:33
 * @Description:
 */
public class Q494 {
    public static void main(String[] args) {
        int[] arr = DataUtil.parseIntArray("[0,0,0,0,0,0,0,0,1]");
        System.out.println(new Q494().findTargetSumWays(arr, 1));
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) return 0;
        int[][] dp = new int[nums.length][2001];

        dp[0][parseIndex(nums[0])]++;
        dp[0][parseIndex(-nums[0])]++;
        for (int i = 1; i < dp.length; i++) {
            int value = nums[i];
            for (int j = -1000; j <= 1000; j++) {
                if (parseIndex(j - value) >= 0) dp[i][parseIndex(j)] += dp[i - 1][parseIndex(j - value)];
                if (parseIndex(j + value) < dp[0].length) dp[i][parseIndex(j)] += dp[i - 1][parseIndex(j + value)];
            }
        }
        
        return dp[dp.length - 1][S + 1000];
    }

    private int parseIndex(int index) {
        return index + 1000;
    }
}


