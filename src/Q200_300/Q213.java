package Q200_300;
/*
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * Q198题改一下，在第一间房不偷和最后一间不偷中取最大值
 */
public class Q213 {
	public static void main(String[] args) {
		int arr[]= {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
		System.out.println(rob(arr));
	}
	public static int rob(int[] nums) {
		if(nums.length==0)	return 0;
		if(nums.length==1)	return nums[0];
		if(nums.length==2)	return Math.max(nums[0], nums[1]);
		
		int money[]=new int[nums.length];
		boolean first[]=new boolean[nums.length];
		money[0]=nums[0];
		first[0]=true;
		if(nums[0]>nums[1]) {
			money[1]=nums[0];
			first[1]=true;
		}else money[1]=nums[1];
		
		for(int i=2;i<nums.length;i++) {
			if(money[i-2]+nums[i]>=money[i-1]) {
				money[i]=money[i-2]+nums[i];
				first[i]=first[i-2];
			}else {
				money[i]=money[i-1];
				first[i]=first[i-1];
			}
		}
		for(int i=0;i<money.length;i++) {
			System.out.println(money[i]+" "+first[i]);
		}
		
		if(first[nums.length-1]==true)	return money[money.length-2];
		else	return money[money.length-1];
    }
}
