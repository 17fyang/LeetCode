package weekMatch.double_week.d53;

import publicUtil.DataUtil;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/29 22:39
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[][] arr = DataUtil.parseDoubleIntArray("[[7,7]]");
        System.out.println(Arrays.toString(new Q03().getBiggestThree(arr)));
    }

    public int[] getBiggestThree(int[][] grid) {
        if (grid.length == 0) return new int[0];


        MaxThree max = new MaxThree();
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                max.getOne(ints[j]);
            }
        }

        if (grid.length < 3 || grid[0].length < 3) return max.toArr();


        int m = grid.length;
        int n = grid[0].length;
        int minLen = Math.min(m, n);

        for (int i = 3; i <= minLen; i += 2) {
            int[][] template = template(i);
            for (int k = 0; k <= m - i; k++) {
                for (int j = 0; j <= n - i; j++) {
                    int sum = 0;
                    for (int[] locate : template) {
                        sum += grid[locate[0] + k][locate[1] + j];
                    }
                    max.getOne(sum);
                }
            }

        }


        return max.toArr();
    }

    private int[][] template(int level) {
        int len = level / 2;
        int[][] temp = new int[len * 4][2];

        int[][] start = new int[][]{{len, 0}, {0, len}, {len, level - 1}, {level - 1, len}};

        int index = 0;
        for (int i = 0; i < len; i++) {
            temp[index][0] = start[0][0] - i;
            temp[index++][1] = start[0][1] + i;

            temp[index][0] = start[1][0] + i;
            temp[index++][1] = start[1][1] + i;

            temp[index][0] = start[2][0] + i;
            temp[index++][1] = start[2][1] - i;

            temp[index][0] = start[3][0] - i;
            temp[index++][1] = start[3][1] - i;
        }
        return temp;
    }

    static class MaxThree {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;


        public void getOne(int value) {
            if (value == max1 || value == max2 || value == max3) return;
            if (value > max1) {
                max3 = max2;
                max2 = max1;
                max1 = value;
            } else if (value > max2) {
                max3 = max2;
                max2 = value;
            } else if (value > max3) {
                max3 = value;
            }
        }

        public int[] toArr() {
            if (max2 == Integer.MIN_VALUE) return new int[]{max1};
            if (max3 == Integer.MIN_VALUE) return new int[]{max1, max2};
            return new int[]{max1, max2, max3};
        }

    }
}
