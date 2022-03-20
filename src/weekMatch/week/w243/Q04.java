package weekMatch.week.w243;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/30 11:22
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {

    }

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int sum = 0;
        for (int i : dist) sum += i;
        if (speed * hoursBefore <= sum) return -1;

        return 0;
    }
}
