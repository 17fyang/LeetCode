package Q600_700;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/12 11:43
 * @Description:
 */
public class Q640 {
    public static void main(String[] args) {
        System.out.println(new Q640().solveEquation("-x=-1"));
    }

    public String solveEquation(String equation) {
        String[] doubleStr = equation.split("=");
        String left = doubleStr[0];
        String right = doubleStr[1];

        int[] leftArr = calculate(left);
        int[] rightArr = calculate(right);

        int xNum = leftArr[0] - rightArr[0];
        int normalNum = rightArr[1] - leftArr[1];

        if (xNum == 0 && normalNum == 0) return "Infinite solutions";

        if (xNum == 0) return "No solution";

        return "x=" + normalNum / xNum;
    }

    private int[] calculate(String s) {
        int xRes = 0;
        int res = 0;
        char[] arr = s.toCharArray();
        List<Integer> queue = new ArrayList<>();
        queue.add(1);
        for (char c : arr) {
            if (c == '+') queue.add(1);
            else if (c == '-') queue.add(-1);
        }

        String[] nums = s.split("[+-]");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].equals("")) nums[i] = "0";
            if (nums[i].endsWith("x")) {
                String xi = nums[i].substring(0, nums[i].length() - 1);
                if (xi.equals(""))
                    xRes += queue.get(i);
                else
                    xRes += (queue.get(i) * Integer.parseInt(xi));
            } else {
                res += (Integer.parseInt(nums[i]) * queue.get(i));
            }
        }

        return new int[]{xRes, res};
    }
}
