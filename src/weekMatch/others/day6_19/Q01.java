package weekMatch.others.day6_19;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/6/19 21:54
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public int leastMinutes(int n) {
        if (n < 3) return n;

        int times = Integer.MAX_VALUE;


        for (int i = 1; i < 17; i++) {
            int speed = 1 << i;

            int temp = i + (n % speed == 0 ? n / speed : n / speed + 1);

            times = Math.min(temp, times);
        }
        return times;
    }
}
