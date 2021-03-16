package offer.meituan_3_13;

import java.util.Scanner;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/13 15:52
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((j == 0 ? "" : " ") + res[i][j]);
            }
            System.out.println();
        }
    }
}
