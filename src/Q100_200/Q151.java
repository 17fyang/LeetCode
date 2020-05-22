package Q100_200;
/*
 * 给定一个字符串，逐个翻转字符串中的每个单词。
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
