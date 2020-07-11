package SwordMeansOffer;

import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time��2020��6��26�� ����10:12:43
 * @Issue:��ת�������С���� ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 *                  ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 *                  ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 *                  NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class Pre06 {

	public static int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int low = 0;
		int high = array.length - 1;
		int mid = low;
		while (array[low] >= array[high]) {
			if (high - low == 1) {
				mid = high;
				break;
			}
			mid = low + (high - low) / 2;
			if (array[low] == array[mid] && array[mid] == array[high]) {
				return ordinalGetMin(array, low, high);
			}
			if (array[low] <= array[high]) {
				high = mid;
			} else if (array[mid] <= array[high]) {
				high = mid;
			}

		}
		return array[mid];
	}

	public static int ordinalGetMin(int[] array, int low, int high) {
		for (int i = low + 1; i < high; i++) {
			if (array[i] < array[i - 1]) {
				return array[i];
			}
		}
		return array[low];
	}

	private static void reverseArray(int start, int end, int[] array) {
		for (int i = start; i <= end; i++) {
			int temp = array[i];
			array[i] = array[end - i];
			array[end - i] = temp;
		}
	}

	private static void revolveArray(int index, int[] array) {
		reverseArray(0, index, array);
		reverseArray(index + 1, array.length - 1, array);
		reverseArray(0, array.length, array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = input.nextInt();
			}
			System.out.println(minNumberInRotateArray(array));
		}
	}

}
