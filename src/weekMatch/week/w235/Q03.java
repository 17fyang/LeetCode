package weekMatch.week.w235;

import java.util.TreeSet;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/4/21 13:55
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{56, 51, 39, 1, 12, 14, 58, 82, 18, 41, 70, 64, 18, 7, 44, 90, 55, 23, 11, 79, 59, 76, 67, 92, 60, 80, 57, 11, 66, 32, 76, 73, 35, 65, 55, 37, 38, 26, 4, 7, 64, 84, 98, 61, 78, 1, 80, 33, 5, 66, 32, 30, 52, 29, 41, 2, 21, 83, 30, 35, 21, 30, 13, 26, 36, 93, 81, 41, 98, 23, 20, 19, 45, 52, 25, 51, 52, 24, 2, 45, 21, 97, 11, 92, 28, 37, 58, 29, 5, 18, 98, 94, 86, 65, 88, 8, 75, 12, 9, 66};
        int[] arr2 = new int[]{64, 32, 98, 65, 67, 40, 71, 93, 74, 24, 49, 80, 98, 35, 86, 52, 99, 65, 15, 92, 83, 84, 80, 71, 46, 11, 26, 70, 80, 2, 81, 57, 97, 12, 68, 10, 49, 80, 24, 18, 45, 72, 33, 94, 60, 5, 94, 99, 14, 41, 25, 83, 77, 67, 49, 70, 94, 83, 55, 17, 61, 44, 50, 62, 3, 36, 67, 10, 2, 39, 53, 62, 44, 72, 66, 7, 3, 6, 80, 38, 43, 100, 17, 25, 24, 78, 8, 4, 36, 86, 9, 68, 99, 64, 65, 15, 42, 59, 79, 66};
        System.out.println(new Q03().minAbsoluteSumDiff(arr1, arr2));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long sum = 0;

        Node.setValue(nums1, nums2);

        TreeSet<Node> set = new TreeSet<>((n1, n2) -> {
            if (n1.value != n2.value) return n1.value - n2.value;
            return n1.index - n2.index;
        });
        for (int i = 0; i < nums1.length; i++) {
            set.add(new Node(i));
            sum += Math.abs(nums1[i] - nums2[i]);
        }

        Node[] arr = set.toArray(new Node[0]);

        int maxEarn = 0;
        for (Node node : arr) {
            int temp = Math.abs(node.value - node.other);
            int index = binarySearch(arr, node.other);
            maxEarn = Math.max(maxEarn, temp - Math.abs(arr[index].value - node.other));
        }
        return (int) ((sum - maxEarn) % 1000000007);
    }

    private int binarySearch(Node[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid].value == value) return mid;
            else if (arr[mid].value > value) right = mid;
            else left = mid;
        }

        if (right == arr.length) return left;
        return (value - arr[left].value) > (arr[right].value - value) ? right : left;
    }

    static class Node {
        int index;
        int value;
        int other;

        public Node(int index) {
            this.index = index;
            this.value = nums1[index];
            this.other = nums2[index];
        }

        static int[] nums1;
        static int[] nums2;

        static void setValue(int[] n1, int[] n2) {
            nums1 = n1;
            nums2 = n2;
        }
    }
}
