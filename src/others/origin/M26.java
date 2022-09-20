package others.origin;

import publicUtil.TreeNode;

/**
 * ClassName: M26
 * Description:
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * date: 2020/5/30 14:46
 *
 * @author :乌鸦坐飞机亠
 * @version:
 */
public class M26 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;

        TreeNode b2 = new TreeNode(4);
        TreeNode b3 = new TreeNode(1);
        b2.left = b3;

        System.out.println(new M26().isSubStructure(n1, b2));

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return func(A, B);
    }

    private boolean func(TreeNode a, TreeNode b) {
        if (a == null) return false;
        boolean flag = false;
        if (a.val == b.val) flag = compare(a, b);
        if (flag == true) return true;
        return func(a.left, b) || func(a.right, b);
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.val != b.val) return false;
        return compare(a.left, b.left) && compare(a.right, b.right);
    }
}
