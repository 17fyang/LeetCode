package Q1400_1500;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/7/19 23:34
 */
public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += cardPoints[i];
        }

        int last = max;
        for (int i = 1; i <= k; i++) {
            last -= cardPoints[k - i];
            last += cardPoints[cardPoints.length - i];
            max = Math.max(last, max);
        }
        return max;
    }
}

