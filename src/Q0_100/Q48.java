package Q0_100;

import publicUtil.DataUtil;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/24 11:16
 * @Description:
 */
public class Q48 {
    public static void main(String[] args) {
        int[][] arr = DataUtil.parseDoubleIntArray("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        new Q48().rotate(arr);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - i * 2 - 1; j++) {
                int temp = matrix[i + j][n - i - 1];
                matrix[i + j][n - i - 1] = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - i - j - 1][i];
                matrix[n - i - j - 1][i] = matrix[n - i - 1][n - i - j - 1];
                matrix[n - i - 1][n - i - j - 1] = temp;
            }
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%2d", ints[j]) + ",");
            }
            System.out.println();
        }

    }
}
