package weekMatch.double_week.d45;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/6 23:00
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {

    }

    public int minimumLength(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] != arr[right]) return right - left + 1;
            if (left == right) return 1;

            while (left < arr.length - 1 && arr[left + 1] == arr[left]) left++;
            left++;
            while (right > 0 && arr[right - 1] == arr[right]) right--;
            right--;
        }
        return 0;
    }
}
