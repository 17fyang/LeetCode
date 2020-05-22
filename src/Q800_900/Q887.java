package Q800_900;

import java.util.HashMap;
import java.util.Map;

/*
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，
 * 从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）
 * 并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 */
public class Q887 {
	public static void main(String[] args) {
//		for(int i=1;i<=3;i++) {
//			for(int j=1;j<=14;j++) {
//				System.out.print(dp(i,j));
//			}
//			System.out.println();
//		}
		System.out.println(solution(3,14));
	}
	
	static Map<Integer, Integer> memo = new HashMap();
    public static int dp(int K, int N) {
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1)
                ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }
                ans = 1 + Math.min(Math.max(dp(K-1, lo-1), dp(K, N-lo)),
                                   Math.max(dp(K-1, hi-1), dp(K, N-hi)));
            }
            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }
	public static int solution(int k,int n) {
		int arr[][]=new int[k][n];
		for(int i=0;i<k;i++) {
			arr[i][0]=1;
			arr[i][1]=2;
		}
		for(int i=0;i<arr[0].length;i++) 	arr[0][i]=i+1;
		
		
		for(int i=1;i<k;i++) {
			for(int j=2;j<arr[0].length;j++) {
				int min=Integer.MAX_VALUE;
				for(int t=1;t<=j;t++) {
					if(Math.max(arr[i-1][t-1], arr[i][j-t])<min)	min=Math.max(arr[i-1][t-1], arr[i][j-t]);
				}
				arr[i][j]=min+1;
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		return arr[k-1][n-1];
	}
}
