package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����1:44:40
* @Issue:��̬��̨��
* ̰���㷨
* һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
* �����������һ��n����̨���ܹ��ж�����������
*/
public class Pre09 {
	
	public static int jumpFloorII1(int target) {
		if (target==0||target==1) {
			return 1;
		}
		return fastPow(2,target-1);
	}

	private static int fastPow(int base, int index) {
		// TODO Auto-generated method stub
		int result=1;
		int temp=base;
		while (index!=0) {
			if( (index&1) ==1){
				result*=temp;
			}
			temp*=temp;
			index>>=1;
		}
		return result;
	}
	
	public static int jumpFloorII2(int target) {
		int result=1;
		while (--target>0) {
			result*=2;
		}
		return result;
	}
	
	public static int jumpFloorII3(int target) {
		return 1 << (target - 1);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			System.out.println(jumpFloorII1(n));
			System.out.println(jumpFloorII2(n));
			System.out.println(jumpFloorII3(n));
		}
	}

}
