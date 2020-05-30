package Q1300_1400;

/**
 * ClassName: Q1385
 * Description:
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此描述的元素数目：
 * 对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * date: 2020/5/30 14:17
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class Q1385 {
    public static void main(String[] args) {

    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int num = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    num--;
                    break;
                }
            }
        }
        return num;
    }
}
