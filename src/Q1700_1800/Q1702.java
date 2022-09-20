package Q1700_1800;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/9/14 23:34
 */
public class Q1702 {
    public static void main(String[] args) {
        System.out.println(new Q1702().maximumBinaryString("1100"));
    }

    public String maximumBinaryString(String binary) {
        char[] arr = binary.toCharArray();

        int index = 0;
        int nextZero = 0;
        while (index < arr.length) {
            while (index < arr.length && arr[index] == '1') {
                index++;
            }

            nextZero = Math.max(index + 1, nextZero);
            while (nextZero < arr.length && arr[nextZero] == '1') {
                nextZero++;
            }

            if (nextZero >= arr.length) {
                break;
            } else {
                arr[index] = '1';
                arr[nextZero] = '1';
                arr[index + 1] = '0';
            }
        }
        return new String(arr);
    }
}
