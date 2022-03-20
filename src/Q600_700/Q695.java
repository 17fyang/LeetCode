package Q600_700;

import publicUtil.Constant;
import publicUtil.DataUtil;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/6/20 15:16
 * @Description:
 */
public class Q695 {
    public static void main(String[] args) {
        int[][] arr = DataUtil.parseDoubleIntArray("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]");
        System.out.println(new Q695().maxAreaOfIsland(arr));
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        Location[][] location = new Location[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                location[i][j] = new Location(i, j, grid[i][j]);
            }
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !flag[i][j]) {
                    int island = bfs(flag, location, location[i][j]);
                    max = Math.max(island, max);
                }
            }
        }
        return max;
    }

    public int bfs(boolean[][] flag, Location[][] locations, Location start) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(start);

        int num = 0;
        while (!queue.isEmpty()) {
            Location l = queue.poll();
            flag[l.x][l.y] = true;
            num++;

            for (int[] direct : Constant.DIRECT) {
                int x = l.x + direct[0];
                int y = l.y + direct[1];

                if (x >= 0 && y >= 0 && x < locations.length && y < locations[0].length && locations[x][y].type == 1 && !flag[x][y]) {
                    queue.add(locations[x][y]);
                    flag[x][y] = true;
                }

            }
        }
        return num;
    }

    static class Location {
        int x;
        int y;
        int type;

        public Location(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x &&
                    y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
