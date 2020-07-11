package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月26日 上午11:29:35
* @Issue:跳台阶
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
* 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
* 递归
*/
public class Pre08 {

	//递归
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
