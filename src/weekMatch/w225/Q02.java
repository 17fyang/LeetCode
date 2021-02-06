package weekMatch.w225;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/1/24 10:29
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {

    }

    public int minCharacters(String a, String b) {
        if (a.length() == 0 || b.length() == 0) return 1;

        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

//        Arrays.sort(aa);
//        Arrays.sort(bb);
        int min = compare(aa, bb);
        min = Math.min(compare(bb, aa), min);

        Map<Character, Integer> map = new HashMap<>();
        for (char c : aa) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : bb) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int total = aa.length + bb.length;
        for (int num : map.values()) {
            min = Math.min(total - num, min);
        }

        return min;

    }

    private int compare(char[] aa, char[] bb) {
        int[][] dp = new int[aa.length][bb.length];
        char[][] value = new char[aa.length][bb.length];
        dp[0][0] = aa[0] < bb[0] ? 0 : 1;
        value[0][0] = aa[0] < bb[0] ? bb[0] : 'z';
        return 0;
    }
}
