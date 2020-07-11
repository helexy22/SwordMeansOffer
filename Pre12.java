package SwordMeansOffer;

import java.util.Iterator;
import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����3:42:24
* @Issue:��ֵ�������η�
* ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
* ��֤base��exponent��ͬʱΪ0
*/
public class Pre12 {
	
	//------������˼��
	public static double Power(double base,int exponent) {
		if (equal(base,0.0)&&exponent<0) {
			throw new IllegalArgumentException("��ĸ����Ϊ0");
		}
		int absExponent=exponent<0?-exponent:exponent;
		double result=1;
		double t=base;
		while (absExponent!=0) {
			if ((absExponent&1)==1) {
				result*=t;
			}
			t*=t;
			absExponent>>=1;
		}
		return exponent<0?1.0/result:result;
	}
	
	//�ж������Ƿ����
	private static boolean equal(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1-num2<1e-8&&num1-num2>1e-8;
	}
	
	//------�ݹ����ʽ�������
	public static double recursivePow(double base,int exponent) {
		if (exponent==0) {
			return 0;
		}
		if (exponent==1) {
			return base;
		}
		double result=recursivePow(base, exponent >> 1);
		if((exponent&1)==1) {
			result*=result;
		}
		return result;
	}
	
	///------��򵥵�˼·
	public static double Power2(double base,int exponent) {
		double result=1.0;
		for (int i = 0; i <=exponent; i++) {
			result*=result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			double base=input.nextDouble();
			int exponent=input.nextInt();
			System.out.println(Power(base,exponent));
		}
	}
	

}
