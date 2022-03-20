package weekMatch.week.w235;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/21 13:55
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
