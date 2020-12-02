package offer;

public class Q33 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61};
        System.out.println(new Q33().verifyPostorder(arr));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) return true;
        return this.isTree(postorder, 0, postorder.length);
    }

    private boolean isTree(int[] arr, int start, int end) {
        if (start >= end - 1) return true;
        int head = arr[end - 1];
        int right = -1;
        for (int i = start; i < end - 1; i++) {
            if (arr[i] > head && right == -1) {
                right = i;
            } else if (arr[i] < head && right != -1) {
                return false;
            }
        }

        System.out.println(start + " " + end + " " + right);

        boolean rightBool;
        boolean leftBool;
        if (right != -1) {
            rightBool = isTree(arr, right, end - 1);
            leftBool = isTree(arr, start, right);
        } else {
            leftBool = isTree(arr, start, end - 1);
            rightBool = true;
        }

        return rightBool && leftBool;
    }
}
