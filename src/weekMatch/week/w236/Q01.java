package weekMatch.week.w236;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/8 17:44
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int noPositive = 0;
        for (int i : nums) {
            if (i == 0) return 0;
            else if (i < 0) noPositive++;
        }
        return noPositive % 2 == 0 ? 1 : -1;
    }
}
