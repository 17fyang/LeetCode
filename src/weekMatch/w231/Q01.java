package weekMatch.w231;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/7 10:28
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        System.out.println(new Q01().checkOnesSegment("10110000"));

    }

    public boolean checkOnesSegment(String s) {
        char[] arr = s.toCharArray();

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                if (flag) return false;
                while (i < arr.length && arr[i] == '1') i++;
                flag = true;
            }
        }
        return true;
    }
}
