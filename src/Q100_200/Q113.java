package Q100_200;

import java.util.LinkedList;
import java.util.List;

/*
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class Q113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root==null)  return new LinkedList<List<Integer>>();
		List<Integer> list=new  LinkedList<Integer>();
		List<List<Integer>> result=new  LinkedList<List<Integer>>();
		func(root,sum,0,list,result);
		return result;
	}
	public void func(TreeNode root,int sum,int tempSum,List<Integer> list,List<List<Integer>> result){
		tempSum+=root.val;
		list.add(root.val);

		if(root.left==null && root.right==null && tempSum==sum)		
				result.add(new LinkedList<Integer>(list));

		if(root.left!=null) func(root.left,sum,tempSum,list,result);
		if(root.right!=null) func(root.right,sum,tempSum,list,result);

		for(int i=list.size()-1;i>=0;i--){
			if(list.get(i).equals(root.val)){
				list.remove(i);   
				break; 
			}   
		}
		return;
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}