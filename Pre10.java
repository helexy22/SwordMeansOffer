package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����1:53:38
* @Issue:���󸲸�
* �ݹ��㷨
* ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
* ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
*/
public class Pre10 {

	//��ͨ�ݹ�
	//���м�����������������ݵ��÷�
	public static int rectCover1(int target) {
		if (target==0|target==1) {
			return target;
		}
		if (target==2) {
			return 2;
		}
		return rectCover1(target-1)+rectCover1(target-2);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			System.out.println(rectCover1(n));
		}
	}
}
