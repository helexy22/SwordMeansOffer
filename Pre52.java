package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年7月1日 下午2:07:46
* @Issue:正则表达式匹配
* 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
* 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
* 在本题中，匹配是指字符串的所有字符匹配整个模式。
* 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
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
	
	//-------有限状态自动机做法
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
