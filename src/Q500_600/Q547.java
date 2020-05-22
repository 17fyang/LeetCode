package Q500_600;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。
 * 他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
 * 那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 */
public class Q547 {
	public static void main(String[] args) {
		int arr[][]=new int[4][];
		arr[0]=new int[]{1,0,0,1};
		arr[1]=new int[]{0,1,1,0};
		arr[2]=new int[] {0,1,1,1};
		arr[3]=new int[] {1,0,1,1};
		int result=findCircleNum(arr);
		System.out.println(result);
	}
	public static int findCircleNum(int[][] m) {
		boolean visit[]=new  boolean[m.length];
		Queue<Integer>	q=new LinkedList<Integer>();
		int count=0;
		for(int i=0;i<m.length;i++) {
			if(visit[i]==false) {
				count++;
			}else {
				continue;
			}
			
			q.add(i);
			while(!q.isEmpty()) {
				int location=q.poll();
				visit[location]=true;
				for(int j=0;j<m.length;j++) {
					if(location==j)	continue;
					if(m[location][j]==1 && visit[j]==false) {
						q.add(j);
					}
				}
			}
		}
		return count;
	}
}
