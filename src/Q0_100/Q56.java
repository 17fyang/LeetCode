package Q0_100;

import java.util.LinkedList;
import java.util.List;

/*
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Q56 {
	public static void main(String[] args) {
		int arr[][]=new int[2][];
		arr[0]=new int[] {1,4};
		arr[1]=new int[] {2,3};
		arr=merge(arr);
		System.out.println();
	}
	public static int[][] merge(int[][] intervals) {
		if(intervals.length==0)	return new int[0][0];
		Couple couples[]=new  Couple[intervals.length];
		for(int i=0;i<intervals.length;i++) {
			Couple couple=new Couple(intervals[i][0],intervals[i][1]);
			for(int j=i;j>=0;j--) {
				if(j==0) {
					couples[0]=couple;
					break;
				}else if(couple.start>=couples[j-1].start)		{
					couples[j]=couple;
					break;
				}else{
					couples[j]=couples[j-1];
				}
			}
		}
		
		List<int[]> list=new LinkedList<int[]>();
		int start=couples[0].start;
		int end=couples[0].end;
		for(int i=1;i<couples.length;i++) {
			if(couples[i].start<=end)	end=Math.max(couples[i].end,end);
			else {
				int arr[]=new int[] {start,end};
				list.add(arr);
				start=couples[i].start;
				end=couples[i].end;
			}
		}
		if(couples[couples.length-1].start<=end) {
			end=Math.max(couples[couples.length-1].end,end);
			int arr[]=new int[] {start,end};
			list.add(arr);
		}else {
			int arr[]=new int[] {couples[couples.length-1].start,couples[couples.length-1].end};
			list.add(arr);
		}
		
		int arr[][]=new int[list.size()][];
		for(int i=0;i<list.size();i++) {
			arr[i]=list.get(i);
		}
        return arr;
    }
}
class Couple{
	int start=0;
	int end=0;
	public Couple(int start,int end) {
		this.start=start;
		this.end=end;
	}
}
