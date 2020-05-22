package others;

/*
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

注意：本题相对原题稍作改动

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-masseuse-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1716 {
	private static int  max=0;
	public static void main(String[] args) {
//		int nums[]= {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
		int nums[]= {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123};
		int result=massage(nums);
		System.out.println(result);
	}
	public static int massage(int[] nums) {
		func(nums,0,0);
		func(nums,0,1);
		return max;
    }
	public static void func(int nums[],int total,int i) {
		if(i>=nums.length-2) {
			int temp=0;
			if(i<nums.length)	temp=total+nums[i];
			if(total>=max )		max=temp;
			return;
		}
		func(nums,total+nums[i],i+2);
		if(i!=nums.length-3)	func(nums,total+nums[i],i+3);
		return;
	}
}
