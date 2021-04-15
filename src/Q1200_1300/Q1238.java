package Q1200_1300;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/2 11:44
 * @Description:
 */
public class Q1238 {
    public static void main(String[] args) {
        System.out.println(new Q1238().circularPermutation(2, 3));
    }

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            int left = (int) Math.pow(2, i);
            int right = i == 0 ? -1 : (int) Math.pow(2, i - 1);
            for (int j = left; j > right; j--) {
                list.add(start ^ j);
            }
        }

        return list;
    }
}
