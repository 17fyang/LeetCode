package Q800_900;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/9 16:01
 * @Description:
 */
public class Q842 {
    public static void main(String[] args) {
        System.out.println(new Q842().splitIntoFibonacci("11235813"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        char[] arr = S.toCharArray();
        for (int i = arr.length / 2; i <= arr.length / 3 * 2 + 1; i++) {
            for (int j = 1; j < i; j++) {
                int maxLen = Math.max(j, i - j);
                if (maxLen < (arr.length - i)) continue;
                List<Integer> list = canSplit(arr, j, i);
                if (list != null) return list;
            }
        }
        return new LinkedList<>();
    }

    private List<Integer> canSplit(char[] arr, int start, int end) {
        if (arr[0] == '0' && start != 1) return null;
        if (arr[start] == '0' && end - start != 1) return null;

        int left = Integer.parseInt(String.valueOf(arr, 0, start));
        int right = Integer.parseInt(String.valueOf(arr, start, end - start));
        int result = Integer.parseInt(String.valueOf(arr, end, arr.length - end));
        if (left + right == result) return Arrays.asList(left, right, result);
        else return null;
    }
}
