package SwordMeansOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time��2020��6��28�� ����10:59:30
 * @Issue:���� ��ֻ����������2��3��5��������������Ugly Number���� ����6��8���ǳ�������14���ǣ���Ϊ������������7��
 *           ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */
public class Pre33 {

	static int[] result = new int[2000];

	// �򵥵�ʾ����number һֱ�ڱ仯���ж�ĳ���Ƿ��ǳ���
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

	// ------�������е�������ȡ������
	public static int GetUglyNumber_Solution(int index) {
		if (index < 7) {
			return index;
		}
		int count = 0;
		// ��7��ʼ���ӣ�Ѱ��
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

	// -----��������� ��������������
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
