package SwordMeansOffer;

import java.util.Scanner;

/**
 * 对应2012年面试题3，P38
 * @author Helexy22
 * @version Time：2020年6月25日 下午9:06:31 
 * @Issue :二维数组的查找
 * 		在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *      请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Pre01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int[][] array = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					array[i][j] = input.nextInt();
				}
			}
			int target = input.nextInt();
			System.out.println(Find1(target, array));
//			System.out.println(Find2(target, array));

		}
	}

	// 先确定所在行，然后在改行中二分法比较
	private static boolean Find2(int target, int[][] array) {
		// TODO Auto-generated method stub
		int row = array.length;
		int col = array[0].length;
		if (row == 0 || col == 0) {
			return false;
		}
		int r = 0; // target 与每行最大值比较，确定所在行
		for (; r < row && array[r][col - 1] < target; r++)
			;

		// 在该行二分法查找，标准的二分法
		for (; r < row; r++) {
			int low = 0;
			int high = col - 1;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (target == array[r][mid]) {
					return true;
				} else if (target < array[r][mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return false;
	}

	// 与每行最大值比较，大了就下移，小了就左移
	private static boolean Find1(int target, int[][] array) {
		// TODO Auto-generated method stub
		int row = array.length;
		int col = array[0].length;
		for (int i = 0, j = col - 1; i < row && j >= 0;) {
			if (target == array[i][j]) {
				return true;
			}
			if (target < array[i][j]) {
				j--;
			} else if (target > array[i][j]) {
				i++;
			}
		}
		return false;
	}

}
