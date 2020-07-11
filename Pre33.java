package SwordMeansOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time：2020年6月28日 上午10:59:30
 * @Issue:丑数 把只包含质因子2、3和5的数称作丑数（Ugly Number）。 例如6、8都是丑数，但14不是，因为它包含质因子7。
 *           习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Pre33 {

	static int[] result = new int[2000];

	// 简单的示例，number 一直在变化，判断某数是否是丑数
	public static boolean isUglyNumber(int number) {
		while (number % 2 == 0) {
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		return number == 1;
	}

	// ------在连续中的数字中取出丑数
	public static int GetUglyNumber_Solution(int index) {
		if (index < 7) {
			return index;
		}
		int count = 0;
		// 从7开始增加，寻找
		for (int i = 7;; i++) {
			if (isUglyNumber(i)) {
				count++;
				if (count == index) {
					result[index] = i;
					return i;
				}
			}
		}
	}

	// -----正向推算出 丑数的排列数组
	public static int GetUglyNumber_Solution2(int index) {
		if (index < 7) {
			return 7;
		}
		int[] result = new int[index];
		result[0] = 1;
		int factor2 = 0;
		int factor3 = 0;
		int factor5 = 0;
		for (int i = 1; i < index; i++) {
			//
			int nextUglyNumber = Math.min(Math.min(result[factor2] * 2, result[factor3] * 3), result[factor5] * 5);
			result[i] = nextUglyNumber;
			if (result[factor2] * 2 == nextUglyNumber) {
				factor2++;
			}
			if (result[factor3] * 3 == nextUglyNumber) {
				factor3++;
			}
			if (result[factor5] * 5 == nextUglyNumber) {
				factor5++;
			}

		}
		return result[index - 1];
	}

	// ------
	public static int GetUglyNumber_Solution3(int index) {
		if (index < 7) {
			return index;
		}
		Queue<Integer> factor2 = new LinkedList<>();
		Queue<Integer> factor3 = new LinkedList<>();
		Queue<Integer> factor5 = new LinkedList<>();
		factor2.add(2);
		factor3.add(3);
		factor5.add(5);
		int result = 0;
		for (int i = 2; i <= index; i++) {
			result = Math.min(Math.min(factor2.peek(), factor3.peek()), factor5.peek());
			if (result == factor2.peek()) {
				factor2.add(result * 2);
				factor3.add(result * 3);
				factor2.poll();
			} else if (result == factor3.peek()) {
				factor3.add(result * 3);
				factor3.poll();
			} else {
				factor5.poll();
			}
			factor5.add(result * 5);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int index = input.nextInt();
			System.out.println(GetUglyNumber_Solution(index));
		}
	}
}
