package publicUtil;

/**
 * @author: ��ѻ���ɻ���
 * @date: 2021/4/21 14:55
 * @Description:�㷨ģ����
 */
public class Template {

    /**
     * ����ֵ�Ķ��ֲ��ң������������ֵ���±�index
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
