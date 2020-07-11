package SwordMeansOffer;

import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time��2020��7��1�� ����2:42:39
 * @Issue:��ʾ��ֵ���ַ��� ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 *                 ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 *                 ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
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
				 * +����������ĩβ������"+", "2+", "2e+" ��û��e���ֵ�ʱ�򣬾ͳ������˷�0λ�ã�����"2+3" �ڳ���e֮��"+,
				 * -"û�н�����e���֣�����"2.3e4+5" ��Щ���ǡ�+���������Ϸ�
				 */
				if (i == str.length - 1 || (i != 0 && !e) || (e && str[i - 1] != 'e' && str[i - 1] != 'E')) {
					return false;
				}
			} else if (ch == '.') {
				/**
				 * ��. e ���ֹ���. �����ٳ����� ��. Ϊ��0λʱ������������Ϊ1����'.'������ֵ ��. Ϊ��0λʱ��.����һλ���������� ��.
				 * Ϊ�����һλʱ��.��ǰһλ���������� ��. λ�ڷ���βʱ������ֻҪһ�������ּ���
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

	// ɨ������ŵ���������
	public static boolean scanInteger(char[] str) {
		// TODO Auto-generated method stub
		if (index < str.length && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		return scanUnsignedInteger(str);
	}

	// ɨ�費�����ŵ���������
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
