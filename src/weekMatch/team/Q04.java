package weekMatch.team;

import java.util.Arrays;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/10 14:54
 * @Description:
 */
public class Q04 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 2, 3, 4, 1, 3, 6};
        System.out.println(new Q04().maxGroupNumber(arr));
    }

    public int maxGroupNumber(int[] tiles) {
        Arrays.sort(tiles);

        if (tiles.length < 3) return 0;

        int result = 0;
        int start = 0;
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i] - tiles[i - 1] > 1) {
                result += solution(tiles, start, i);
                start = i;
            }
        }
        result += solution(tiles, start, tiles.length);

        return result;
    }

    private int solution(int[] arr, int start, int end) {
        int[] times = new int[arr[end - 1] - arr[start] + 1];
        Arrays.fill(times, 1);
        int location = 0;
        for (int j = start + 1; j < end; j++) {
            if (arr[j] == arr[j - 1]) times[location]++;
            else location++;
        }
        return part(times);
    }

    private int part(int[] arr) {
        if (arr.length < 3) return Arrays.stream(arr).map((i) -> i / 3).sum();


        int result = 0;

        for (int j = 0; j < arr.length; j++) {
            while (arr[j] > 4) {
                arr[j] -= 3;
                result++;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            while (arr[i] > 1 && arr[i - 1] > 1 && arr[i - 2] > 1) {
                result++;
                arr[i]--;
                arr[i - 1]--;
                arr[i - 2]--;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            result += arr[j] / 3;
            arr[j] = arr[j] % 3;
        }

        for (int i = 2; i < arr.length; i++) {
            while (arr[i] > 0 && arr[i - 1] > 0 && arr[i - 2] > 0) {
                result++;
                arr[i]--;
                arr[i - 1]--;
                arr[i - 2]--;
            }
        }
        return result;
    }

    private boolean fit(int[] arr, int index) {
        if (!(arr[index] == arr[index - 1] && arr[index - 1] == arr[index - 2])) return false;
        return arr[index] - arr[index - 1] == 1 && arr[index] - arr[index - 2] == 2;
    }
}
