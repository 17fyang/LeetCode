package weekMatch.single;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/5 14:50
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[] arr = new int[]{100, -50, 100, -150, -60, -140, -50, -50, 300, 750};

        System.out.println(new Q03().magicTower(arr));
    }

    public int magicTower(int[] nums) {
        long total = 1;
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            arr[i] = total;
        }
        if (total <= 0) return -1;

        TreeSet<Point> set = new TreeSet<>((p1, p2) -> {
            if (p1.kou != p2.kou) return p1.kou - p2.kou;
            else return p1.index - p2.index;
        });

        System.out.println(Arrays.toString(arr));

        long removeNum = 0;
        int addTime = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] - removeNum > 0) {
                set.add(new Point(nums[i], i));
            } else {
                set.add(new Point(nums[i], i));
                while (arr[i] - removeNum <= 0) {
                    if (set.isEmpty()) break;
                    Point first = set.first();
                    if (first.kou >= 0) break;

                    set.remove(first);
                    removeNum += first.kou;
                    addTime++;
                }

            }
        }
        return addTime;
    }
}

class Point {
    int kou;
    int index;

    public Point(int kou, int index) {
        this.kou = kou;
        this.index = index;
    }
}
