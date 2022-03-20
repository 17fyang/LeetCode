package weekMatch.double_week.d53;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/29 22:30
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public int countGoodSubstrings(String s) {
        char[] arr = s.toCharArray();

        if (arr.length < 3) return 0;

        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] != arr[i + 1] && arr[i + 1] != arr[i + 2] && arr[i] != arr[i + 2]) count++;
        }
        return count;
    }
}
