package Q0_100;

/*
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 */
public class Q06 {
	public static void main(String[] args) {
		String s="LEETCODEISHIRING";
		int num=2;
		String result=convert(s,num);
		System.out.println(result);
	}
	public static String convert(String s, int numRows) {
		if(s==null)	return null;
		char c[]=s.toCharArray();
		if(numRows<2)	return s;
		
		StringBuilder sb=new StringBuilder();
		int interval=numRows-2;
		
		for(int i=0;i<numRows;i++) {
			func(sb,c,numRows,interval,i);
			interval--;
			if(i==numRows-1)	interval=numRows-2;
		}
		return sb.toString();
    }
	static void func(StringBuilder sb,char c[],int numRows,int interval,int startLocation) {
		if(startLocation>=c.length)		return;
		sb.append(c[startLocation]);
		int location=startLocation+(interval+1)*2;
		if(location>=c.length)		return;
		if(!(location==startLocation) && !((location-startLocation)==(numRows*2-2))) {
			sb.append(c[location]);
		}
		func(sb,c,numRows,interval,startLocation+numRows*2-2);
	}
	
}
