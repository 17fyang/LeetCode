package Q500_600;
/*
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，
 * 力扣 希望在 IPO 之前开展一些项目以增加其资本。 
 * 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。
 * 帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，
 * 并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。
 * 当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本。
 * 并输出最终可获得的最多资本。
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
