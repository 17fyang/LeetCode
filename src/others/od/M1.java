package others.od;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/24 10:26
 */
public class M1 {
    public static void main(String[] args) {
        System.out.println(solution("82300090", 3));

    }

    private static String solution(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        char[] arr = num.toCharArray();

        int left = 0;
        for (int i = k; i < arr.length; i++) {
            char next = arr[i];
            while (k > 0) {
                boolean noFound = false;
                for (int j = left; j <= i; j++) {
                    if (arr[j] > next) {
                        arr[j] = ' ';
                        k--;
                        left = j;
                        break;
                    } else if (j == i) {
                        noFound = true;
                    }
                }
                if (noFound) {
                    break;
                }
            }
        }

        num = new String(arr).replaceAll(" +", "");
        return String.valueOf(Long.parseLong(num));
    }
}
