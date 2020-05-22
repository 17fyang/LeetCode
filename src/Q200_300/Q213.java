package Q200_300;
/*
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�
 * ����ط����еķ��ݶ�Χ��һȦ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�
 * ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬
 * �������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 * 
 * Q198���һ�£��ڵ�һ�䷿��͵�����һ�䲻͵��ȡ���ֵ
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
