package weekMatch.week.w229;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/21 10:28
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int left = 0;
        int right = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while (left < arr1.length && right < arr2.length) {
            if (flag) {
                sb.append(arr1[left++]);
            } else {
                sb.append(arr2[right++]);
            }
            flag = !flag;
        }

        while (left < arr1.length) sb.append(arr1[left++]);
        while (right < arr2.length) sb.append(arr2[right++]);

        return sb.toString();
    }

}
