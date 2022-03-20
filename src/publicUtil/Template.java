package publicUtil;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/4/21 14:55
 * @Description:算法模板类
 */
public class Template {

    /**
     * 近似值的二分查找，返回最相近的值的下标index
     *
     * @param arr
     * @param value
     * @return
     */
    public static int similarBinarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) return mid;
            else if (arr[mid] > value) right = mid;
            else left = mid;
        }

        if (right == arr.length) return left;
        return (value - arr[left]) > (arr[right] - value) ? right : left;
    }
}
