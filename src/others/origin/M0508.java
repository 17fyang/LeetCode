package others.origin;

import java.util.Arrays;

/**
 * @author: ��ѻ���ɻ���
 * @date: 2021/1/12 18:03
 * @Description:
 */
public class M0508 {
    public static void main(String[] args) {
        int[] arr = new M0508().drawLine(15, 96, 81, 95, 1);
        System.out.println(Arrays.toString(arr));
    }

    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int times = w / 32;
        int[][] arr = new int[length / times][times];
        int startInt = x1 / 32;
        int startBit = x1 % 32;
        int endInt = x2 / 32;
        int endBit = (x2 - endInt * 32) % 32;


        char[] bits = new char[32];
        int bitLocation = startBit;
        for (int i = startInt; i < endInt; i++) {
            initBits(bits);
            for (int j = bitLocation; j < bits.length; j++) bits[j] = '1';
            bitLocation = 0;
            arr[y][i] = parseCharArr(bits);
        }
        initBits(bits);
        for (int i = bitLocation; i <= endBit; i++) bits[i] = '1';
        arr[y][endInt] = parseCharArr(bits);
        int[] result = new int[length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i * arr[0].length + j] = arr[i][j];
            }
        }
        return result;
    }

    private int parseCharArr(char[] bits) {
        return (int) Long.parseLong(new String(bits), 2);
    }

    private void initBits(char[] bits) {
        Arrays.fill(bits, '0');
    }
}
