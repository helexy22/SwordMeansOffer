package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��7��1�� ����2:07:46
* @Issue:������ʽƥ��
* ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
* ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� 
* �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
* ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
*/
public class Pre52 {

	//--------
	public static boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		int i = 0, j = 0;
		while (i < str.length && j < pattern.length) {
			char ch1 = str[i];
			char ch2 = pattern[j];
			if (ch1 == ch2 || ch2 == '.') {
				i++;
				j++;
			} else if (ch2 == '*') {
				if (j == 0 || (pattern[j - 1] != ch1 && pattern[j - 1] != '.')) {
					return false;
				} else {
					i++;
					if (i == str.length) {
						return true;
					}
				}
			} else {
				if ((j + 1) < pattern.length && pattern[j + 1] == '*') {
					if (ch1 != pattern[j - 1]) {
						j += 2;
					} else {
						i++;
					}
				} else {
					return false;
				}
			}
		}
		return i == str.length && j == pattern.length;
	}
	
	//-------����״̬�Զ�������
	public static boolean match2(char[] str,char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return matchCore(str,0,pattern,0);
	}

	public static boolean matchCore(char[] str, int index1, char[] pattern, int index2) {
		// TODO Auto-generated method stub
		if (index1==str.length&&index2==pattern.length) {
			return true;
		}
		if (index1!=str.length&&index2!=pattern.length) {
			return false;
		}
		//*
		if ((index2+1)<pattern.length&&pattern[index2+1]=='*' ){
			if (index1<str.length&&(str[index1]==pattern[index2]||pattern[index2]=='.')) {
				return matchCore(str,index1,pattern,index2+2);
			}else {
				return matchCore(str,index1,pattern,index2+2);
			}
		}
		//
		else {
			if (index1<str.length&&(str[index1]==pattern[index2]||pattern[index2]=='.')) {
				return matchCore(str,index1+1,pattern,index2+1);
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str1=input.next();
			String str2=input.next();
			System.out.println(match2(str1.toCharArray(),str2.toCharArray()));
		}
	}
}
