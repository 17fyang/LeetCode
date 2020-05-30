package Q0_100;

/**
 * ClassName: Q09
 * Description:判断是否是回文数
 * date: 2020/5/30 16:43
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class Q09 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char c[] = s.toCharArray();
        int i = 0;
        int j = c.length;
        while (i < j) {
            if (c[i] == c[j]) {
                i++;
                j--;
            } else
                break;
        }
        if (i < j) return false;
        else return true;
    }

}
