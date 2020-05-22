package tencents;

public class dynamic01 {
	public static void main(String[] args) {
		int result=climbStairs(44);
		System.out.println(result);
	}
    public static int climbStairs(int n) {	
    	int arr[]=new int[n+1];
    	arr[0]=0;
    	if(n>=1)	arr[1]=1;
    	if(n>=2)	arr[2]=2;
        for(int i=3;i<=n;i++) {
        	arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
