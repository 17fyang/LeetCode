package Q100_200;
/*
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�
 * ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 */
public class Q198 {
	public static void main(String[] args) {
		int arr[]={2,1,1,2};
		System.out.println(rob(arr));
	}
	public static int rob(int[] nums) {
		if(nums.length==0)	return 0;
		if(nums.length==1)	return nums[0];
		if(nums.length==2)	return Math.max(nums[0], nums[1]);
		int money[]=new int[nums.length];
		money[0]=nums[0];
		money[1]=Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++) {
			money[i]=Math.max(money[i-2]+nums[i],money[i-1]);
		}
		return money[money.length-1];
    }
}
