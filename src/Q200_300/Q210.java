package Q200_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，
我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组
 */
public class Q210 {
	public static void main(String[] args) {
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Node>arr=new ArrayList<Node>(numCourses);
		List<Node>temp=new ArrayList<Node>(numCourses);
		for(int i=0;i<numCourses;i++) 		arr.add(new Node());
		for(int i=0;i<numCourses;i++) 		temp.add(arr.get(i));
		for(int i=0;i<prerequisites.length;i++) {
			arr.get(prerequisites[i][0]).next.add(arr.get(prerequisites[i][1]));
			arr.get(prerequisites[i][1]).last.add(arr.get(prerequisites[i][0]));
		}
		int[]	result=new  int[numCourses];
		int locate=0;
		while(!temp.isEmpty()) {
			int beforeLength=temp.size();
			for(Node n : temp) {
				if(n.last.isEmpty()) {
					temp.remove(n);
					result[locate++]=arr.indexOf(n);
					List<Node>nextList=n.next;
					for(Node tempNode:nextList)	tempNode.last.remove(n);
				}
			}
			if(temp.size()==beforeLength)		break;
		}
		if(!temp.isEmpty())	return new int[] {};
		return result;
    }
}
class Node{
	List<Node> next=new  LinkedList<Node>();
	List<Node> last=new  LinkedList<Node>();
}

