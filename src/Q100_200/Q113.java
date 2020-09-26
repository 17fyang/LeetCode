package Q100_200;

import publicUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root ==null) return new ArrayList<>();

        List<List<Integer>> resultList=new LinkedList<>();
        Queue<NodeAndList> queue=new LinkedList<>();
        List<Integer> list=new LinkedList<>();
        list.add(root.val);
        queue.add(new NodeAndList(root,list,root.val));
        while(!queue.isEmpty()){
            NodeAndList n=queue.poll();
            if (n.node.left==null && n.node.right==null && n.value==sum)    resultList.add(n.list);
            if(n.node.left!=null){
                List<Integer> newList=new LinkedList<>(n.list);
                newList.add(n.node.left.val);
                queue.add(new NodeAndList(n.node.left,newList,n.node.left.val+n.value));
            }
            if(n.node.right!=null){
                List<Integer> newList=new LinkedList<>(n.list);
                newList.add(n.node.right.val);
                queue.add(new NodeAndList(n.node.right,newList,n.node.right.val+n.value));
            }
        }
        return resultList;
    }
}
class NodeAndList{
    TreeNode node;
    List<Integer> list;
    int value=0;

    public NodeAndList(TreeNode node, List<Integer> list, int value) {
        this.node = node;
        this.list = list;
        this.value = value;
    }
}