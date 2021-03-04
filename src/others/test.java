package others;


import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            char[] s = sc.next().toCharArray();

            int len = s.length;
            for (int i = 0; i < len; i++) {
                boolean flag = false;
                if (i <= s.length - 3 && s[i] == s[i + 1] && s[i + 1] == s[i + 2]) {
                    len--;
                    flag = true;
                    removeIndex(s, i, len);
                }

                if (i <= s.length - 4 && s[i] == s[i + 1] && s[i + 1] != s[i + 2] && s[i + 2] == s[i + 3]) {
                    len--;
                    flag = true;
                    removeIndex(s, i + 2, len);
                }

                if (flag) i--;
            }

            char[] result = new char[len];
            if (result.length >= 0) System.arraycopy(s, 0, result, 0, result.length);

            System.out.println(new String(result));

        }
    }
    

    private static void removeIndex(char[] s, int index, int len) {
        System.arraycopy(s, index + 1, s, index, len - index);
        s[len] = (char) -1;
    }

}