package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��28�� ����10:13:44
* @Issue:������1���ֵĴ���
* ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
* ���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
* ���ҡ���ѧ���е�
*/
public class Pre30 {
	
	//----- ����ƴ���ַ�����Ȼ���������1�ĸ���
	public static int NumberOf1Between1AndN_Solution(int n) {
		int count=0;
		for (int i = 0; i < n; i++) {
			String num=String.valueOf(i);
			for (int j = 0; j < num.length(); j++) {
				//�ж��ַ���Ȼ�����
				count+=num.charAt(i)=='1'?1:0;
			}
		}
		return count;
	}

	//----��������ÿһλ��ͳ��1�ĸ���
	public static int NumberOf1Between1AndN_Solution2(int n) {
		int count=0;
		for (int i = 0; i < n; i++) {
			while (i!=0) {
				//���һλ
				if (i%10==1) {
					count++;
				}
				//��ǰ��һλ
				i/=10;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			System.out.println(NumberOf1Between1AndN_Solution2(n));
		}
	}
}
