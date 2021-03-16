package Q200_300;

import publicUtil.TreeNode;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/3/12 13:26
 * @Description: java.lang.NullPointerException
 * at line 26, Solution.lowestCommonAncestor
 * at line 55, __DriverSolution__.__helper__
 * at line 102, __Driver__.main
 */
public class Q236 {
    private MyTreeNode highNode;
    private MyTreeNode lowNode;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        highNode = null;
        lowNode = null;
        MyTreeNode head = bfs(root, p, q, 0);

        if (highNode.level < lowNode.level) {
            MyTreeNode m = highNode;
            highNode = lowNode;
            lowNode = m;
        }

        while (lowNode.level < highNode.level) {

            highNode = highNode.father;
        }

        while (lowNode != highNode) {
            lowNode = lowNode.father;
            highNode = highNode.father;
        }

        return lowNode.node;
    }

    private MyTreeNode bfs(TreeNode node, TreeNode p, TreeNode q, int level) {
        MyTreeNode myTreeNode = new MyTreeNode(node, level);

        if (node == p || node == q) {
            if (lowNode == null)
                lowNode = myTreeNode;
            else
                highNode = myTreeNode;
        }

        if (node.left != null) bfs(node.left, p, q, level + 1).father = myTreeNode;
        if (node.right != null) bfs(node.right, p, q, level + 1).father = myTreeNode;
        return myTreeNode;
    }
}

class MyTreeNode {
    TreeNode node;
    int level;
    MyTreeNode father;

    public MyTreeNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
