package weekMatch.w234;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/28 10:28
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {

    }

    public String evaluate(String s, List<List<String>> knowledge) {
        char[] arr = s.toCharArray();

        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        int left = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') left = i;

            if (left == -1) sb.append(arr[i]);

            if (arr[i] == ')') {
                String key = String.valueOf(arr, left + 1, i - left);
                System.out.println(key);
                sb.append(map.getOrDefault(key, "?"));
                left = -1;
            }

        }
        return sb.toString();
    }
}
