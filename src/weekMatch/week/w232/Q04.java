package weekMatch.week.w232;

import publicUtil.DataUtil;

import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/14 10:57
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {
        int i = 9732;
        int[] arr = DataUtil.parseIntArray("[6569,9667,3148,7698,1622,2194,793,9041,1670,1872]");
        System.out.println(new Q04().maximumScore(arr, 5));
    }

    public int maximumScore(int[] nums, int k) {

        TreeSet<MyPoint> left = new TreeSet<>((p1, p2) -> {
            if (p1.val != p2.val) return p1.val - p2.val;
            else return p1.index - p2.index;
        });

        TreeSet<MyPoint> right = new TreeSet<>((p1, p2) -> {
            if (p1.val != p2.val) return p1.val - p2.val;
            else return p2.index - p1.index;
        });

        for (int i = 0; i <= k; i++) {
            left.add(new MyPoint(i, nums[i]));
        }

        for (int i = k; i < nums.length; i++) {
            right.add(new MyPoint(i, nums[i]));
        }

        int max = nums[k];
        while (!left.isEmpty() && !right.isEmpty()) {
            MyPoint leftFirst = left.first();
            MyPoint rightFirst = right.first();

            max = Math.max(max, Math.min(leftFirst.val, rightFirst.val) * (rightFirst.index - leftFirst.index + 1));

            if (leftFirst.index == rightFirst.index) {
                left.remove(leftFirst);
                right.remove(rightFirst);
            } else if (leftFirst.val < rightFirst.val) {
                left.remove(leftFirst);
            } else {
                right.remove(rightFirst);
            }

        }
        return max;
    }
}

class MyPoint {
    int index;
    int val;

    public MyPoint(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
