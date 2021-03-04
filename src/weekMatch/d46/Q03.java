package weekMatch.d46;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/20 22:20
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {

    }

    public int[][] highestPeak(int[][] isWater) {
        Point[][] points = new Point[isWater.length][isWater[0].length];

        int xLen = isWater.length;
        int yLen = isWater[0].length;

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                points[i][j] = new Point(i, j);
            }
        }

        LinkedList<Point> waterList = new LinkedList<>();

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    waterList.add(points[i][j]);
                    points[i][j].height = 0;
                }
            }
        }

        int height = 0;

        Queue<Point> heightList = waterList;
        while (!heightList.isEmpty()) {
            height++;
            int len = heightList.size();
            for (int i = 0; i < len; i++) {
                Point p = heightList.poll();

                if (p.x > 0 && points[p.x - 1][p.y].height > height) {
                    points[p.x - 1][p.y].height = height;
                    heightList.add(points[p.x - 1][p.y]);
                }

                if (p.y > 0 && points[p.x][p.y - 1].height > height) {
                    points[p.x][p.y - 1].height = height;
                    heightList.add(points[p.x][p.y - 1]);
                }

                if (p.x < xLen - 1 && points[p.x + 1][p.y].height > height) {
                    points[p.x + 1][p.y].height = height;
                    heightList.add(points[p.x + 1][p.y]);
                }

                if (p.y < yLen - 1 && points[p.x][p.y + 1].height > height) {
                    points[p.x][p.y + 1].height = height;
                    heightList.add(points[p.x][p.y + 1]);
                }


//                if (p.y > 0) heightList.add(points[p.x][p.y - 1]);
//                if (p.x < xLen - 1) heightList.add(points[p.x + 1][p.y]);
//                if (p.y < yLen - 1) heightList.add(points[p.x][p.y + 1]);
            }
        }


        return Point.toHeight(points);


    }
}

class Point {
    int x;
    int y;
    int height = Integer.MAX_VALUE;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static int[][] toHeight(Point[][] points) {
        int[][] height = new int[points.length][points[0].length];
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[0].length; j++) {
                height[i][j] = points[i][j].height;
            }
        }
        return height;
    }
}
