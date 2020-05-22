package Q0_100;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 */
public class Q10 {
	public static void main(String[] args) {
		String s="dasodias";
		String p="dasd";
		boolean result=isMatch(s,p);
		System.out.println(result);
	}
	public static boolean isMatch(String s, String regex) {
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(s);
		return m.matches();
    }
}
