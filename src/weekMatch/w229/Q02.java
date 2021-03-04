package weekMatch.w229;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/21 10:28
 * @Description:
 */
public class Q02 {
    public static void main(String[] args) {

    }

    public int[] minOperations(String boxes) {
        char[] arr = boxes.toCharArray();

        int[] opera = new int[arr.length];
        int rightNums = 0;
        int leftNums = 0;
        for (int i = 1; i < arr.length; i++) {
            opera[0] += (arr[i] == '0' ? 0 : i);
            rightNums += (arr[i] == '0' ? 0 : 1);
        }

        for (int i = 1; i < opera.length; i++) {
            leftNums += (arr[i - 1] == '0' ? 0 : 1);
            if (arr[i] == '0') {
                opera[i] = opera[i - 1] - rightNums + leftNums;
            } else {
                rightNums--;
                opera[i] = opera[i - 1] - rightNums - 1 + leftNums;
            }
        }
        return opera;
    }
}
