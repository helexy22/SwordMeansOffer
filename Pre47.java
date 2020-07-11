package SwordMeansOffer;

/**
 * @author Helexy22
 * @version Time��2020��6��29�� ����3:09:43
 * @Issue:��1+2+3+����+n ��1+2+3+...+n��
 * Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */
public class Pre47 {

	// ------���ö�·�߼���
	public static int Sum_Solution(int n) {
		int sum = n;
		boolean flag = (n != 0 && (sum += Sum_Solution(n - 1)) >= 0);
		return sum;
	}

	// ----��·���߼���
	public static int Sum_Solution2(int n) {
		int sum = n;
		boolean flag = (n == 0 || (sum += Sum_Solution2(n - 1)) >= 0);
		return sum;
	}

	// -----
	public static int Sum_Solution3(int n) {
		return ((int) Math.pow(n, 2) + n) >> 1;
	}

	// -----����ģ��
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
