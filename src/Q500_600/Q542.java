package Q500_600;

import java.util.LinkedList;
import java.util.Queue;
/*
 * ����һ���� 0 �� 1 ��ɵľ����ҳ�ÿ��Ԫ�ص������ 0 �ľ��롣��������Ԫ�ؼ�ľ���Ϊ 1 ��
 * 
 * �����������Ĺ����������������Ŀ�����������Ҫ������Ҫ�㣺
 * 1����μ�¼ÿ����������ȣ�
 * ȡ��ǰ���г��ȣ��������г��ȵ�Ԫ�أ�Ȼ�����Ԫ���ں��棬һ�δ���֮��step++��
 * 2����ô��¼�µ�ǰλ�õ����ֵ��
 * ��Ϊ���ֵ��Ҫ̽�����ײ�֮����ܼ�¼����BFS̽�����ײ�֮�󲻻��¼ԭλ�ã�
 * ���Կ��Բ����Ե����ϣ��ӵײ�Ԫ������������
 * 
 * besides�����ʹ�ó������Ŀռ������Ŀ����: ���ȡ
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
