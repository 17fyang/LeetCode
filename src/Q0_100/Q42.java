package Q0_100;
/*
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ��
 * ���㰴�����е����ӣ�����֮���ܽӶ�����ˮ
 */
public class Q42 {
	public static void main(String[] args) {
		int height[]= {0,1,0,2,1,0,1,3,2,1,2,1};
		int result=trap(height);
		System.out.println(result);
	}
	public static int trap(int[] height) {
		if(height==null || height.length<=2)	return 0;
		
		int index=maxIndex(height);
		int totalResult=0;
		int max=height[0];
		int maxIndex=0;
		for(int  i=1;i<=index;i++) {
			if(height[i]>=max) {
				for(int j=maxIndex+1;j<i;j++) {
					totalResult+=max-height[j];
				}
				max=height[i];
				maxIndex=i;
			}
		}
		
		max=height[height.length-1];
		maxIndex=height.length-1;
		for(int  i=height.length-1;i>=index;i--) {
			if(height[i]>=max) {
				for(int j=maxIndex-1;j>i;j--) {
					totalResult+=max-height[j];
				}
				max=height[i];
				maxIndex=i;
			}
		}
		
        return totalResult;
    }
	private static int maxIndex(int[] height) {
		int max=height[0];
		int maxIndex=0;
		for(int i=1;i<height.length;i++) {
			if(height[i]>max) {
				max=height[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
}
