package others.od;

import java.util.Scanner;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/15 21:26
 */
public class Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int flagOr = 0;
        int sum = 0;
        while (n-- > 0) {
            int weight = sc.nextInt();
            min = Math.min(weight, min);
            flagOr = flagOr ^ weight;
            sum += weight;
        }

        if (flagOr != 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum - min);
        }
    }

}
