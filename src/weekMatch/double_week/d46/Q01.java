package weekMatch.double_week.d46;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/20 22:20
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {
        System.out.println(new Q01().longestNiceSubstring("dfFmuHDMrEeRhU"));
    }

    public String longestNiceSubstring(String s) {
        char[] arr = s.toCharArray();

        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j <= arr.length; j++) {
                if (isPerfect(arr, i, j) && (j - i) > maxLen) {
                    maxStart = i;
                    maxEnd = j;
                    maxLen = j - i;
                }
            }
        }

        return s.substring(maxStart, maxEnd);
    }

    private boolean isPerfect(char[] arr, int start, int end) {

        Set<Character> smallSet = new HashSet<>();
        Set<Character> bigSet = new HashSet<>();

        for (int i = start; i < end; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                smallSet.add(arr[i]);
            } else {
                bigSet.add(arr[i]);
            }
        }

        if (smallSet.size() != bigSet.size()) return false;

        for (Character character : smallSet) {
            char c = (char) (character - 32);
            if (!bigSet.remove(c)) return false;
        }
        return true;
    }
}
