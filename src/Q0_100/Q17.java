package Q0_100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/15 13:01
 * @Description:
 */
public class Q17 {
    public static final char[][] cc = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) return new LinkedList<>();
        char[] locate = digits.toCharArray();

        List<String> list = new LinkedList<>();
        track(list, new char[locate.length], locate, 0);
        return list;
    }

    private void track(List<String> list, char[] arr, char[] locate, int index) {
        if (index >= locate.length) {
            list.add(String.valueOf(arr));
            return;
        }

        char[] words = cc[locate[index] - '2'];
        for (char word : words) {
            arr[index] = word;
            track(list, arr, locate, index + 1);
        }
    }

}
