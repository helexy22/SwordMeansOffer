package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月28日 下午1:53:11
* @Issue:第一个只出现一次的字符位置
* 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
* 字符串、较难
*/
public class Pre34 {
	
	//
	public static int FirstNotRepeatingChar(String str) {
		if (str!=null) {
			int length='z'-'A'+1;
			int[] count=new int[length];
			for (int i = 0; i < str.length(); i++) {
				count[str.charAt(i)-'A']++;
			}
			for (int i = 0; i < str.length(); i++) {
				if (count[str.charAt(i)-'A']==1) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str=input.next();
			System.out.println(FirstNotRepeatingChar(str));
		}
	}
}
