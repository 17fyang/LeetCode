package weekMatch.week.w236;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/8 17:44
 * @Description:
 */
public class Q02 {

    private int f(int n, int k) {
        if (n == 1) return 0;
        return (k % n + f(n - 1, k)) % n;
    }

    public int findTheWinner(int n, int k) {
        return f(n, k) + 1;
    }
}
