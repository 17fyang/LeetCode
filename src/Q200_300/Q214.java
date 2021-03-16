package Q200_300;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/16 15:49
 * @Description:
 */
public class Q214 {
    public static void main(String[] args) {
        System.out.println(new Q214().shortestPalindrome(""));
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.equals("")) return "";
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i > 0; i--) {
            int left = 0;
            int right = i;
            while (arr[left] == arr[right]) {
                left++;
                right--;
                if (left >= right) {
                    return addAndReturn(s, i + 1);
                }
            }
        }
        return addAndReturn(s, 1);

    }

    private String addAndReturn(String s, int start) {
        StringBuilder sb = new StringBuilder(s.substring(start));

        return sb.reverse().toString() + s;
    }
}
