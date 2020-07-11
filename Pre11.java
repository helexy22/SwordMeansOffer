package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月26日 下午3:31:58
* @Issue:二进制中1的个数
* 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
*/
public class Pre11 {

	//通过移位操作进行
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
	
	//左移辅助变量
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
