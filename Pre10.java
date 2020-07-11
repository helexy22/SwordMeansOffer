package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月26日 下午1:53:38
* @Issue:矩阵覆盖
* 递归算法
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*/
public class Pre10 {

	//普通递归
	//还有记忆搜索、矩阵快速幂的用法
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
