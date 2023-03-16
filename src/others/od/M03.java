package others.od;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/29 21:12
 */
public class M03 {
    public static void main(String[] args) {
        System.out.println(new M03().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        dp(n, n, "", list);
        return list;
    }

    private void dp(int left, int right, String prefix, List<String> result) {
        if (left <= 0) {
            result.add(prefix + multiRight(right));
            return;
        }

        if (left <= right) {
            dp(left - 1, right, prefix + "(", result);
        }

        if (left < right) {
            dp(left, right - 1, prefix + ")", result);
        }
    }

    private String multiRight(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(")");
        }
        return sb.toString();
    }
}
