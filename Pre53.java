package SwordMeansOffer;

import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time：2020年7月1日 下午2:42:39
 * @Issue:表示数值的字符串 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *                 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *                 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Pre53 {

	public static boolean isNum(char ch) {
		return ch > '0' && ch <= '9';
	}

	public static boolean isNumberic1(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		boolean decimalPoint = false, e = false;
		for (int i = 0; i < str.length; i++) {
			char ch = str[i];
			if (ch == '+' || ch == '-') {
				/**
				 * +，—出现在末尾，比如"+", "2+", "2e+" 在没有e出现的时候，就出现在了非0位置，比如"2+3" 在出现e之后，"+,
				 * -"没有紧挨着e出现，比如"2.3e4+5" 这些都是“+，—”不合法
				 */
				if (i == str.length - 1 || (i != 0 && !e) || (e && str[i - 1] != 'e' && str[i - 1] != 'E')) {
					return false;
				}
			} else if (ch == '.') {
				/**
				 * 当. e 出现过后，. 不能再出现了 当. 为第0位时，如果串本身就为1，即'.'不是数值 当. 为第0位时，.的下一位必须是数字 当.
				 * 为第最后一位时，.的前一位必须是数字 当. 位于非首尾时，左右只要一方是数字即可
				 */
				if (decimalPoint || e || (i == 0 && (i == str.length - 1 || !isNum(str[i + 1])))
						|| (i == str.length - 1 && !isNum(str[i - 1])) || (!isNum(str[i - 1]) && !isNum(str[i + 1]))) {
					return false;
				}
				decimalPoint = true;
			} else if (ch == 'e' || ch == 'E') {
				if (e || i == 0 || i == str.length - 1) {
					return false;
				}
				e = true;
			} else if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	// ------
	static int index = 0;

	public static boolean isNummeric2(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		index=0;
		boolean result=scanInteger(str);
		if (index<str.length&&str[index]=='.') {
			index++;
			result=scanUnsignedInteger(str)||result;
		}
		if (index<str.length&&(str[index]=='e'||str[index]=='E')) {
			index++;
			result=result&&scanInteger(str);
		}
		return result&&index==str.length;
	}

	// 扫描带符号的整数部分
	public static boolean scanInteger(char[] str) {
		// TODO Auto-generated method stub
		if (index < str.length && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		return scanUnsignedInteger(str);
	}

	// 扫描不带符号的整数部分
	private static boolean scanUnsignedInteger(char[] str) {
		// TODO Auto-generated method stub
		int start = index;
		while (index < str.length && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		return index > start;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = ".2";
		System.out.println(isNumberic1(str.toCharArray()));
		System.out.println(isNummeric2(str.toCharArray()));
	}
}
