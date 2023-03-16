package Q800_900;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/27 23:33
 */
public class Q837 {
    public static void main(String[] args) {
        System.out.println(new Q837().new21Game(257, 256, 10));
    }

    public double new21Game(int n, int k, int maxPts) {
        double pts = 1.0d / maxPts;
        double[] dp = new double[k + 1];
        dp[0] = 1.0;
        for (int i = 1; i <= k; i++) {
            double sum = 0;
            for (int j = 1; i - j >= 0 && j < maxPts; j++) {
                sum += dp[i - j] * pts;
            }
            dp[i] = sum;
        }

        if (k == n) {
            return dp[k];
        }

        double result = 0;

        for (int i = k - maxPts; i < k; i++) {
            if (i < 0) {
                continue;
            }

            int overflow = maxPts + i - k + 1;
            int overN = Math.max(maxPts + i - n + 1, 0);
            result += dp[i] * (overflow - overN) / maxPts;
        }


        return result;
    }
    
}
