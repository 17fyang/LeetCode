package others.od;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/15 21:35
 */
public class Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }

        int[] arr = new int[list.size()];
        int i = 0;
        for (int n : list) {
            arr[i++] = n;
        }
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 0;
            }
        }

        int right = 0;
        while (right < len && arr[right] < 0) {
            right++;
        }

        if (right == len) {
            return Math.abs(arr[len - 1] + arr[len - 2]);
        } else if (right == 0) {
            return Math.abs(arr[0] + arr[1]);
        }

        int left = right - 1;
        int rightNext = right + 1 < len ? arr[right + 1] : Integer.MAX_VALUE;
        int leftLast = left - 1 >= 0 ? arr[left - 1] : Integer.MAX_VALUE;
        int min = Math.abs(arr[right] + rightNext);
        min = Math.min(min, Math.abs(arr[left] + leftLast));


        while (right < len && left >= 0) {
            min = Math.min(Math.abs(arr[left] + arr[right]), min);

            if (right == len - 1) {
                left--;
            } else if (left == 0) {
                right++;
            } else if (Math.abs(arr[right]) > Math.abs(arr[left])) {
                left--;
            } else {
                right++;
            }
        }
        return min;
    }
}
