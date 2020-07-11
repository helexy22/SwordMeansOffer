package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��28�� ����1:53:11
* @Issue:��һ��ֻ����һ�ε��ַ�λ��
* ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.����0��ʼ������
* �ַ���������
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
