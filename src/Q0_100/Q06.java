package Q0_100;

/*
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
 * ���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
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
