package others;

import publicUtil.DataUtil;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/8 9:34
 * @Description:
 */
public class LCP03 {
    public static void main(String[] args) {
        int[][] arr = DataUtil.parseDoubleIntArray("[[10, 5], [1, 6], [6, 10], [3, 0], [0, 3], [0, 10], [6, 2]]");

        System.out.println(new LCP03().robot("RUUR", arr, 7856, 9033));
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int n = command.length();
        int[][] prefixSum = new int[n][];
        char[] arr = command.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] == 'R' ? 0 : 1;
            int[] last = (i == 0) ? new int[]{0, 0} : prefixSum[i - 1];
            prefixSum[i] = new int[]{last[0], last[1]};
            prefixSum[i][index]++;
        }

        for (int[] location : obstacles) {
            if (location[0] == x && location[1] >= y) continue;
            if (location[0] > x) continue;
            if (location[1] > y) continue;


            if (canArrive(prefixSum, location[0], location[1])) return false;
        }
        return canArrive(prefixSum, x, y);
    }

    private boolean canArrive(int[][] prefixSum, int x, int y) {
        int n = prefixSum.length;
        int times = (x + y) / n;
        int xTime = prefixSum[n - 1][0] * times;
        int yTime = prefixSum[n - 1][1] * times;

        int remain = ((x + y) % n) - 1;
        if (remain >= 0) {
            xTime += prefixSum[remain][0];
            yTime += prefixSum[remain][1];
        }

        return xTime == x && yTime == y;
    }
}
