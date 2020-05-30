package Q100_200;

import publicUtil.TreeNode;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。
你可以假设树中没有重复的元素。

递归的时候尽量思考下一步和终止条件即可
 */
public class Q105 {
    public static int pre = 0;

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode head = buildTree(preOrder, inOrder);
//        TreeNode.output(head);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;//用到了静态的全局变量所以每次使用前初始化
        if (preorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        int in = 0;
        for (int i = 0; i < inorder.length; i++)
            if (inorder[i] == preorder[0]) {
                in = i;
                break;
            }
        node.left = func(preorder, inorder, 0, in);
        node.right = func(preorder, inorder, in + 1, inorder.length);
        return node;
    }

    public static TreeNode func(int[] preorder, int[] inorder, int left, int right) {

        for (int i = left; i < right; i++) {
            if (inorder[i] == preorder[pre + 1]) {
                TreeNode node = new TreeNode(inorder[i]);
                pre++;
                node.left = func(preorder, inorder, left, i);
                node.right = func(preorder, inorder, i + 1, right);
                return node;
            }
        }
        return null;
    }
}
