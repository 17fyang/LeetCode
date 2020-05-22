package Q500_600;

import java.util.LinkedList;
import java.util.Queue;
/*
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。两个相邻元素间的距离为 1 。
 * 
 * 解析：多起点的广度优先搜索经典题目，解决问题主要有两个要点：
 * 1、如何记录每次搜索的深度：
 * 取当前队列长度，弹出队列长度的元素，然后把新元素在后面，一次处理之后step++；
 * 2、怎么记录下当前位置的深度值：
 * 因为深度值需要探索到底部之后才能记录，而BFS探索到底部之后不会记录原位置，
 * 所以可以采用自底向上，从底部元素往上搜索。
 * 
 * besides：如何使用常数级的空间完成题目问题: 脏读取
 * 
 */
public class Q542 {
	public static void main(String[] args) {
		
	}
	public int[][] updateMatrix(int[][] matrix) {
		Queue<int[]> q=new LinkedList<int[]>();
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					q.add(new int[] {i,j});
					matrix[i][j]+=10;
				}
			}
		}
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		int step=0;
		while(!q.isEmpty()) {
			int length=q.size();
			for(int i=0;i<length;i++) {
				int location[]=q.poll();
				int value=matrix[location[0]][location[1]]%2;
				if(value==1)	matrix[location[0]][location[1]]=step*100+value+10;
				for(int j=0;j<dx.length;j++) {
					int x=location[0]+dx[j];
					int y=location[1]+dy[j];
					if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || matrix[x][y]/10%2==1)	continue;
					q.add(new int[] {x,y});
					matrix[x][y]+=10;
				}
			}
			step++;
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				matrix[i][j]=matrix[i][j]/100;
			}
		}
        return matrix;
    }
}
