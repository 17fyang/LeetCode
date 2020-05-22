package Q200_300;

import java.util.HashSet;
import java.util.Set;

/*
 * 编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class Q202 {
	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}
	
	public static boolean isHappy(int n) {
		Set<Integer> set=new HashSet<Integer>();
		while(true) {
			if(set.contains(n))		break;
			set.add(n);
			n=func(n);
			if(n==1)	return true;
		}
        return false;
    }
    public static int func(int n){
        char c[]=String.valueOf(n).toCharArray();
        int sum=0;
        for(int i=0;i<c.length;i++) {
        	sum+=Math.pow(c[i]-48, 2);
        }
        return sum;
    }
}
