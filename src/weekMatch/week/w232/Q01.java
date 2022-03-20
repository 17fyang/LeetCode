package weekMatch.week.w232;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/14 10:30
 * @Description:
 */
public class Q01 {
    public static void main(String[] args) {

    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int first = -1;
        int second = -1;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                if (first == -1) first = i;
                else if (second == -1) second = i;
                else return false;
            }
        }

        if (first == -1) return true;
        else if (second == -1) return false;

        return arr1[first] == arr2[second] && arr1[second] == arr2[first];

    }
}
