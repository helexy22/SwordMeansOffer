package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����11:29:35
* @Issue:��̨��
* һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
* �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
* �ݹ�
*/
public class Pre08 {

	//�ݹ�
	public static int jumpFloor11(int target) {
		if(target==0||target==1) {
			return 1;
		}
		return jumpFloor11(target-1)+jumpFloor11(target-2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			System.out.println(jumpFloor11(n));
		}
	}

}
