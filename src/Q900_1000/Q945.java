package Q900_1000;

/*
 * ������������ A��ÿ�� move ��������ѡ������ A[i]����������� 1��
 * ����ʹ A �е�ÿ��ֵ����Ψһ�����ٲ���������
 */
public class Q945 {
	public static void main(String[] args) {
		int A[]= {2,2,2,1};
		int result=minIncrementForUnique(A);
		System.out.println(result);
	}
	public static int minIncrementForUnique(int[] A) {
		if(A.length==0)	return 0;
		int next[]=getNext(A);
		int residue=0;
		int sum=0;
		for(int i=0;i<next.length;i++) {
			if(next[i]>1) {
				residue+=next[i]-1;
			}else if(next[i]==0 && residue!=0) {
				residue--;
			}
			sum+=residue;
		}
		while(residue>0) {
			residue--;
			sum+=residue;
		}
		return sum;
    }
	private static int[] getNext(int[] a) {
		int max=a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i]>max)	max=a[i];
		}
		int next[]=new int[max+1];
		for(int i=0;i<a.length;i++) {
			next[a[i]]++;
		}
		return next;
	}
}
