package Q500_600;
/*
 * ���� ���ۣ�LeetCode��������ʼ�� IPO��Ϊ���Ը��ߵļ۸񽫹�Ʊ��������Ͷ�ʹ�˾��
 * ���� ϣ���� IPO ֮ǰ��չһЩ��Ŀ���������ʱ��� 
 * ������Դ���ޣ���ֻ���� IPO ֮ǰ������ k ����ͬ����Ŀ��
 * ���� ���� ��������� k ����ͬ��Ŀ��õ�������ʱ��ķ�ʽ��
 * �������ɸ���Ŀ������ÿ����Ŀ i��������һ�������� Pi��
 * ������Ҫ��С���ʱ� Ci ��������Ӧ����Ŀ����������� W �ʱ���
 * �������һ����Ŀʱ���㽫��ô����������󽫱���ӵ�������ʱ��С�
 * �ܶ���֮���Ӹ�����Ŀ��ѡ����� k ����ͬ��Ŀ���б�����������ʱ���
 * ��������տɻ�õ�����ʱ���
 */
public class Q502 {
	 public static void main(String[] args) {
		int k=30;
		 int w=0;
		 int Profits[]= {1,2,3};
		 int Capital[]= {0,1,1};
		int result=findMaximizedCapital(k,w,Profits,Capital);
		 System.out.println(result);
	}
	 public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		 int money=W;
		 boolean visit[]=new boolean[Profits.length];
		 int i=0;
		 while(i<k && i<Profits.length) {
			 i++;
			 int location=-1;
			 int max=Integer.MIN_VALUE;
			 for(int j=0;j<Profits.length;j++) {
				 if(visit[j]==true)	continue;
				 if(Capital[j]<=money && (Profits[j])>=max) {
					 location=j;
					 max=Profits[j];
				 }
			 }
			 if(max>=0)	money+=max;
			if(location!=-1)	 visit[location]=true;
		 }
		 return money;
	 }
}
