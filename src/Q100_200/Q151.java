package Q100_200;
/*
 * ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
 */
public class Q151 {
	    public String reverseWords(String s) {
	        String arr[]=s.split(" ");
	        StringBuilder sb=new StringBuilder();
	        for(int i=arr.length-1;i>=0;i--){
	            if(arr[i]!=null && !arr[i].equals("")){
	                sb.append(arr[i]+" ");
	            }
	        }
	        if(sb.length()==0)    return "";
	        sb.delete(sb.length()-1,sb.length());
	        return sb.toString();
	    }
}
