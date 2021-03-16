package weekMatch.d47;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/6 22:25
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int distance = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] != x && point[1] != y) continue;

            int d = Math.abs(point[0] - x) + Math.abs(point[1] - y);
            if (d < distance) {
                distance = d;
                index = i;
            }
        }
        return index;
    }


}
