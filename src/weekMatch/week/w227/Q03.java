package weekMatch.week.w227;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/7 10:29
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        String mysq = "qqqqqqqqqqqqqqqqqeqeqqeeqqqeqqqeeqqeeqqqqqeq";
        String real = "qqqqqqqqqqqqqqqqqeqqqeqeqqeeqqqeeqqeeqqqqqeq";
        System.out.println(new Q03().largestMerge("qqqqqqqqqeqeqqeeqqq", "qqqqqqqqeqqqeeqqeeqqqqqeq"));
        System.out.println(Math.random() > 0.5);
    }

    public String largestMerge(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int left = 0;
        int right = 0;

        StringBuilder sb = new StringBuilder();
        while (left < arr1.length && right < arr2.length) {
            if (arr1[left] > arr2[right]) {
                sb.append(arr1[left++]);
            } else if (arr1[left] < arr2[right]) {
                sb.append(arr2[right++]);
            } else {
                if (compareSame(arr1, arr2, left, right)) {
                    sb.append(arr1[left++]);
                } else {
                    sb.append(arr2[right++]);
                }
            }
        }

        while (left < arr1.length) sb.append(arr1[left++]);
        while (right < arr2.length) sb.append(arr2[right++]);
        return sb.toString();


    }

    private boolean compareSame(char[] arr1, char[] arr2, int left, int right) {
        while (left < arr1.length && right < arr2.length) {
            if (arr1[left] != arr2[right]) return arr1[left] > arr2[right];
            left++;
            right++;
        }
        return left < arr1.length;
    }
}
