package Q0_100;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣
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
