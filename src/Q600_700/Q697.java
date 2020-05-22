package Q600_700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 给你一个非空且只包含非负数的整数数组nums
 * 数组的度的定义是指数组里任一元素出现的频率的最大值
 * 你的任务是找到与nums有相同度的最短连续子数组，返回其长度
 */
public class Q697 {
	public static void main(String[] args) {
		int nums[]= {2,1};
		int result=findShortestSubArray(nums);
		System.out.println(result);
	}
	public static int findShortestSubArray(int[] nums) {
        Set<Integer> set=getSet(nums);
        Iterator<Integer>	it=set.iterator();
        int minLength=nums.length;
        while(it.hasNext()) {
        	int value=it.next();
        	int i=0;
        	int j=nums.length-1;
        	int length=nums.length;
        	while(nums[i++]!=value)	length--;
        	while(nums[j--]!=value)	length--;
        	if(length<minLength)	minLength=length;
        }
        return minLength;
    }
	private static Set<Integer> getSet(int[] nums) {
		Set<Integer> set=new HashSet<Integer>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int max=0;
		for(int i=0;i<nums.length;i++) {
			int k=nums[i];
			Integer v=map.get(k);
			if(v==null)	{
				map.put(k, 1);
				if(max==0)	max=1;
			}
			else {
				map.put(k,v+1);
				if(v+1>max)	max=v+1;
			}
		}
		for(Entry<Integer,Integer> entry:map.entrySet()) {
			if(entry.getValue()==max)		set.add(entry.getKey());
		}
		return set;
	}
}
