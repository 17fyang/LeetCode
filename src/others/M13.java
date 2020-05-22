package others;
/*
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 */
public class M13 {
	private static int sum=0;
	public static void main(String[] args) {
		int result=movingCount(38,15,9);
		System.out.println(result);
	}
    public static int movingCount(int m, int n, int k) {
        boolean flag[][]=new boolean[m][n];
        func(flag,0,0,k);
        return sum;
    }
    static void func(boolean[][] flag,int m,int n,int k){
        if(!(m>=0 && m<flag.length && n>=0 && n<flag[0].length))    return;
        if(flag[m][n]==true)    return;
        if(m/100+m%100/10+m%10+n/100+n%100/10+n%10>k)   return;
        flag[m][n]=true;
        sum++;

        func(flag,m-1,n,k);
        func(flag,m+1,n,k);
        func(flag,m,n-1,k);
        func(flag,m,n+1,k);
    }
}
