package Q1100_1200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/11 13:02
 * @Description:
 */
public class Q1162 {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[]{1, 0, 1};
        arr[1] = new int[]{0, 0, 0};
        arr[2] = new int[]{1, 0, 1};
        System.out.println(new Q1162().maxDistance(arr));
    }

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length) return -1;

        int[][] res = new int[grid.length][grid[0].length];

        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[0].length; j++) res[i][j] = Integer.MAX_VALUE;

        for (int[] t : queue) res[t[0]][t[1]] = 0;

        int max = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] local = queue.poll();
                int x = local[0];
                int y = local[1];
                int step = res[x][y];
                max = Math.max(step, max);
                if (x - 1 >= 0 && res[x - 1][y] != 0 && res[x - 1][y] > step + 1) {
                    res[x - 1][y] = step + 1;
                    queue.add(new int[]{x - 1, y});
                }
                if (x + 1 < res.length && res[x + 1][y] != 0 && res[x + 1][y] > step + 1) {
                    res[x + 1][y] = step + 1;
                    queue.add(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && res[x][y - 1] != 0 && res[x][y - 1] > step + 1) {
                    res[x][y - 1] = step + 1;
                    queue.add(new int[]{x, y - 1});
                }
                if (y + 1 < res[0].length && res[x][y + 1] != 0 && res[x][y + 1] > step + 1) {
                    res[x][y + 1] = step + 1;
                    queue.add(new int[]{x, y + 1});
                }

            }
        }
        return max;
    }

}
