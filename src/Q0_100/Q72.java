package Q0_100;
/*
 * ◊Ó–°±‡º≠æ‡¿ÎÀ„∑®
 * 
 */
public class Q72 {
	public static void main(String[] args) {
		String s1="zoologicoarchaeologist";
		String s2="zoogeologist";
		int result=minDistance(s1,s2);
		System.out.println(result);
	}
	public static int minDistance(String word1, String word2) {
		char c1[]=word1.toCharArray();
		char c2[]=word2.toCharArray();
		
		int arr[][]=new int[c1.length+1][c2.length+1];
		for(int i=0;i<arr.length;i++) arr[i][0]=i;
		for(int i=0;i<arr[0].length;i++) arr[0][i]=i;
		for(int i=1;i<arr[0].length;i++) {
			for(int j=1;j<arr.length;j++) {
				 int left = arr[j - 1][i] + 1;
				 int down = arr[j][i- 1] + 1;
			     int left_down = arr[j - 1][i- 1];
			     if (c1[j- 1] != c2[i - 1])		left_down += 1;
			     arr[j][i] = Math.min(left, Math.min(down, left_down));
			}
		}
		
        return arr[arr.length-1][arr[0].length-1];
    }
}
