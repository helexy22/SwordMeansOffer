package SwordMeansOffer;

import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time：2020年6月26日 上午10:12:43
 * @Issue:旋转数组的最小数字 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *                  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *                  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *                  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
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
