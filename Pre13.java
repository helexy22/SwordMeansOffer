package SwordMeansOffer;

import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time：2020年6月26日 下午3:58:29
 * @Issue:调整数组顺序使奇数位于偶数钱前面 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *                         并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Pre13 {

	// ----借助辅助空间
	public static void reOrderArray1(int[] array) {
		int index = 0;
		int[] newArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1) {
				newArray[index++] = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 0) {
				newArray[index++] = array[i];
			}
		}
		System.arraycopy(newArray, 0, array, 0, array.length);
	}

	// ------原址上操作，但是复杂度会高
	public static void reOrderArray2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1 && i != 0) {
				int index = i;
				while (index > 0 && (array[index - 1] & 1) != 1) {
					int temp = array[index];
					array[index] = array[index - 1];
					array[index - 1] = temp;
					index--;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = input.nextInt();
			}

            //reOrderArray1(array);
			reOrderArray2(array);
			// 打印
			for (int i = 0; i < n; i++) {
				System.out.println(array[i] + " ");
			}
			System.out.println();
		}
	}
}
