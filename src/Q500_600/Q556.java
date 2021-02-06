package Q500_600;


/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/2/2 17:31
 * @Description:
 */
public class Q556 {
    public static void main(String[] args) {
        System.out.println(new Q556().nextGreaterElement(12443322));
    }

    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                if (i == 0) return -1;
                continue;
            }

            int right = arr.length - 1;
            while (arr[i] >= arr[right]) right--;
            swap(arr, i, right);
            reSort(arr, i + 1);

            try {
                return Integer.parseInt(String.valueOf(arr));
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    private void reSort(char[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
