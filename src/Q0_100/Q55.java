package Q0_100;
/*
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class Q55 {
	public static void main(String[] args) {
		int arr[]= {0,1};
		boolean flag=canJump(arr);
		System.out.println(flag);
	}
	public static boolean canJump(int[] nums) {
		int max=nums[0];
		for(int i=0;i<=max && max<nums.length-1;i++) {
			int temp=nums[i];
			if(temp+i>max)	{
				max=temp+i;
			}
		}
		if(max>=nums.length-1)	return true;
		return false;
    }
}
