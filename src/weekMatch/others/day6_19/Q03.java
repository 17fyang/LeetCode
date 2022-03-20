package weekMatch.others.day6_19;

import publicUtil.Constant;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/6/19 21:54
 * @Description:
 */
public class Q03 {

    public static void main(String[] args) {
//        String[] arr = new String[]{"11111100000", "21243101111", "21224101221", "11111101111"};
//        String[] arr = new String[]{"110", "231", "221"};
        String[] arr = new String[]{"115532411", "432151402", "334333015", "553140335", "055541414", "053312015", "503433210", "055431125"};
        System.out.println(new Q03().largestArea(arr));
    }

    public int largestArea(String[] grid) {
        if (grid.length < 3) return 0;

        for (String s : grid) {
            System.out.println(s);
        }


        Location[][] location = new Location[grid.length][grid[0].length()];
        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < location[i].length; j++) {
                location[i][j] = new Location(i, j, grid[i].charAt(j) - '0');
            }
        }
        int max = 0;
        boolean[][] flag = new boolean[grid.length][location[0].length];
        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < location[0].length; j++) {
                if (location[i][j].type != 0 && !flag[i][j]) {
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
        boolean side = false;
        while (!queue.isEmpty()) {
            Location l = queue.poll();
            flag[l.x][l.y] = true;
            num++;

            if (l.x == 0 || l.y == 0 || l.x == (locations.length - 1) || l.y == (locations[0].length - 1)) side = true;

            for (int[] direct : Constant.DIRECT) {
                int x = l.x + direct[0];
                int y = l.y + direct[1];

                if (x >= 0 && y >= 0 && x < locations.length && y < locations[0].length && !flag[x][y]) {
                    if (locations[x][y].type == start.type) {
                        queue.add(locations[x][y]);
                        flag[x][y] = true;
                    } else if (locations[x][y].type == 0) {
                        side = true;
                    }
                }
            }
        }
        return side ? 0 : num;
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
