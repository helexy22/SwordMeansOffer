package SwordMeansOffer;

/**
 * @author Helexy22
 * @version Time：2020年6月29日 下午3:09:43
 * @Issue:求1+2+3+……+n 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Pre47 {

	// ------利用短路逻辑与
	public static int Sum_Solution(int n) {
		int sum = n;
		boolean flag = (n != 0 && (sum += Sum_Solution(n - 1)) >= 0);
		return sum;
	}

	// ----短路的逻辑或
	public static int Sum_Solution2(int n) {
		int sum = n;
		boolean flag = (n == 0 || (sum += Sum_Solution2(n - 1)) >= 0);
		return sum;
	}

	// -----
	public static int Sum_Solution3(int n) {
		return ((int) Math.pow(n, 2) + n) >> 1;
	}

	// -----快速模乘
	static int count;

	public static int Sum_Solution4(int n) {
		int a = n, b = n + 1;
		count = 0;
		return sum(a, b) >> 1;
	}

	static int sum(int a, int b) {
		int sum = 0;
		boolean flag = ((b & 1) != 0) && (sum += (a << count)) > 0;
		count++;
		boolean flag1 = (b != 0) && (sum += sum(a, b >> 1)) > 0;
		return sum;
	}

	// -------
	public static int Sum_Solution5(int n) {
		int a = n, b = n + 1;
		return sumAToB(a, b) >> 1;
	}

	static int sumAToB(int a, int b) {
		int sum = 0;
		boolean flag1 = ((b & 1) != 0) && (sum += a) > 0;
		boolean flag2 = ((b != 0)) && (sum += sumAToB(a << 1, b >> 1)) > 0;
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(Sum_Solution(10000));
	}
}
