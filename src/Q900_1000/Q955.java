package Q900_1000;

/**
 * ClassName: Q955
 * Description:
 * date: 2020/9/26 19:10
 *
 * @author :ÎÚÑ»×ø·É»úÙï
 * @version:
 */
public class Q955 {
    public int minDeletionSize(String[] A) {
        boolean flag[] = new boolean[A.length];
        char[][] c = new char[A.length][];
        for (int i = 0; i < A.length; i++) {
            c[i] = A[i].toCharArray();
        }

        int i = 1;
        int j = 0;
        while (i < A.length || j < A[0].length()) {

            if (flag[j]) j++;
            else if (c[i][j] > c[i - 1][j]) i++;
            else if (c[i][j] == c[i - 1][j]) {
                j++;
            } else {
                flag[j++] = true;
            }
        }
        return 0;
    }
}
