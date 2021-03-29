package weekMatch.w234;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/28 10:28
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {

    }

    public int reinitializePermutation(int n) {
        int location = n - 2;
        int temp = location;
        int time = 0;
        while (time == 0 || temp != location) {
            if (temp % 2 == 0) temp = temp / 2;
            else temp = n / 2 + temp / 2;
            time++;
        }
        return time;
    }
}
