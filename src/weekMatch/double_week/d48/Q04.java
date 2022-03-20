package weekMatch.double_week.d48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/20 22:23
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {

    }

    public int maxScore(int[] nums) {
        Map<Pair, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(new Pair(nums[i], nums[j]), gcd(nums[i], nums[j]));
            }
        }
        return 0;

    }

    public int gcd(int num1, int num2) {
        if (num1 == 0) return num2;
        if (num2 == 0) return num1;

        if (num1 % 2 == 0 && num2 % 2 == 0) {
            return 2 * gcd(num1 / 2, num2 / 2);
        } else if (num1 % 2 == 0) {
            return gcd(num1 / 2, num2);
        } else if (num2 % 2 == 0) {
            return gcd(num1, num2 / 2);
        } else {
            int min = Math.min(num1, num2);
            return gcd(Math.abs(num1 - num2), min);
        }
    }
}

class Pair {
    int p1;
    int p2;

    public Pair(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
