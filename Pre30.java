package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月28日 上午10:13:44
* @Issue:整数中1出现的次数
* 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
* 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
* 查找、数学、中等
*/
public class Pre30 {
	
	//----- 数字拼接字符串，然后遍历，求1的个数
	public static int NumberOf1Between1AndN_Solution(int n) {
		int count=0;
		for (int i = 0; i < n; i++) {
			String num=String.valueOf(i);
			for (int j = 0; j < num.length(); j++) {
				//判断字符，然后计数
				count+=num.charAt(i)=='1'?1:0;
			}
		}
		return count;
	}

	//----遍历数的每一位，统计1的个数
	public static int NumberOf1Between1AndN_Solution2(int n) {
		int count=0;
		for (int i = 0; i < n; i++) {
			while (i!=0) {
				//最后一位
				if (i%10==1) {
					count++;
				}
				//向前移一位
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
