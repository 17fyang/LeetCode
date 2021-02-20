package weekMatch.w228;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/15 10:38
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) sb.append('w');
        System.out.println(new Q02().countHomogenous(sb.toString()));
    }

    public int countHomogenous(String s) {
        if (s.length() < 2) return s.length();
        char[] arr1 = s.toCharArray();
        char[] arr = new char[arr1.length + 1];
        for (int i = 0; i < arr1.length; i++) arr[i] = arr1[i];
        arr[arr.length - 1] = '?';
        char startChar = arr[0];
        int startLocation = 0;
        long result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != startChar) {
                startChar = arr[i];
                result += sameTimes(i - startLocation);
                startLocation = i;
                result %= 1000000007;
            }
        }

        return (int) result;

    }

    private long sameTimes(int length) {
        long i = length;
        return (1 + i) * i / 2;
    }
}
