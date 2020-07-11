package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����3:31:58
* @Issue:��������1�ĸ���
* ����һ���������������32λ�����Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
*/
public class Pre11 {

	//ͨ����λ��������
	public static int numberOf1One(int n) {
		int count=0;
		while(n!=0) {
			if ((n&1)==1){
				count++;
			}
			n>>=1;
		}
		return count;
	}
	
	public static int numberOf1Two(int n) {
		int count=0;
		while (n!=0) {
			count++;
			n&=n-1;
		}
		return count;
	}
	
	//���Ƹ�������
	public static int numberOf1Three(int n) {
		int count=0;
		int t=1;
		for (int i = 0; i <= 32; i++) {
			if((n&t)!=0) {
				count++;
			}
			t<<=1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int num=input.nextInt();
			System.out.println(numberOf1One(num));
			System.out.println(numberOf1Two(num));
			System.out.println(numberOf1Three(Integer.MAX_VALUE));
		}
	}
}
