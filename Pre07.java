package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月26日 上午10:55:33
* @Issue:	斐波那契数列
* 递归思想
* 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）
*/
public class Pre07 {
	
	//循环形式
	public static int Fibonacci11(int n) {
		int first=0;
		int second=1;
		if(n==0)return first;
		if(n==1)return second;
		int result=0;
		for (int i = 2; i <=n; i++) {
			result=first+second;
			first=second;
			second=result;
		}
		return result;
	}
	
	//递归形式
	public static int Fibonacci12(int n) {
		if(n<=1)return n;
		return Fibonacci12(n-1)+Fibonacci12(n-2);
	}
	
	//基于矩阵快速幂的解法
	public static int Fibonacci13(int n) {
		if (n==0)  {
			return 0;
		}
		if (n==1||n==2)  {
			return 1;
		}
		int[][] base= {{1,1},{1,0}};
		int[][] result=fastPowMatrix(base,n-2);
		return result[0][0]+result[1][0];
	}
	public static int[][] fastPowMatrix(int[][] base, int index) {
		// TODO Auto-generated method stub
		int[][] result=new int[base.length][base[0].length];
		for (int i = 0; i < base.length; i++) {
			result[i][i]=1;
		}
		int[][] t=base;
		while (index!=0) {
			if ((index&1)==1) {
				result=multpleMatix(result,t);
			}
			t=multpleMatix(t,t);
			index>>=1;
			
		}
		return result;
	}

	public static int[][] multpleMatix(int[][] left, int[][] right) {
		// TODO Auto-generated method stub
		int[][] result=new int[left.length][right.length];
		for (int i = 0; i < left.length; i++) {
			for (int j = 0; j < right.length; j++) {
				for (int k = 0; k < left[0].length; k++) {
					result[i][j]+=left[i][k]*right[k][j];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			System.out.println(Fibonacci11(n));
			System.out.println(Fibonacci12(n));
			System.out.println(Fibonacci13(n));
		}
	}

}
