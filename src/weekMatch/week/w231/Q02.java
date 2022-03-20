package weekMatch.week.w231;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/7 10:28
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {

    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i : nums) sum += i;

        long abs = Math.abs(goal - sum);
        if (abs % limit == 0) return (int) (abs / limit);
        return (int) (abs / limit + 1);
    }
}
