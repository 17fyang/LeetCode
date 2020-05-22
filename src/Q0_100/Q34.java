package Q0_100;
/*
 * 二分查找
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 */
public class Q34 {
	public static void main(String[] args) {
		int arr[]= {1,4};
		int target=4;
		int result[]=searchRange(arr,target);
		System.out.println(result[0]+" "+result[1]);
	}
	public static  int[] searchRange(int[] nums, int target) {
		if(nums.length==1 && nums[0]==target)	return new int[] {0,0};
		int head=0;
		int tail=nums.length-1;
		while(head<=tail) {
			int mid=(head+tail)/2;
			if(target>nums[mid])	head=mid+1;
			else if(target<nums[mid])	tail=mid-1;
			else {
				head=mid;
				break;
			}
		}
		if(head<=tail) {
			int value=nums[head];
			int location=head;
			while( head-1>=0 && nums[head-1]==value)	head--;
			while( location+1<nums.length && nums[location+1]==value)	location++;
			return new int[] {head,location};
		}
		return new int[] {-1,-1};
    }
}
