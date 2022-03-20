package Q200_300;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/27 15:28
 * @Description:
 */
public class Q292 {
    public static void main(String[] args) {

    }

    public boolean canWinNim(int n) {
        if (n <= 3) return true;
        return n % 4 != 0;
    }
}
