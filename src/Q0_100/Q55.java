package Q0_100;
/*
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * �ж����Ƿ��ܹ��������һ��λ�á�
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
