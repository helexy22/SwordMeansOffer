package SwordMeansOffer;

import java.util.Scanner;

/**
 * ��Ӧ2012��������3��P38
 * @author Helexy22
 * @version Time��2020��6��25�� ����9:06:31 
 * @Issue :��ά����Ĳ���
 * 		��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 *      �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
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

	// ��ȷ�������У�Ȼ���ڸ����ж��ַ��Ƚ�
	private static boolean Find2(int target, int[][] array) {
		// TODO Auto-generated method stub
		int row = array.length;
		int col = array[0].length;
		if (row == 0 || col == 0) {
			return false;
		}
		int r = 0; // target ��ÿ�����ֵ�Ƚϣ�ȷ��������
		for (; r < row && array[r][col - 1] < target; r++)
			;

		// �ڸ��ж��ַ����ң���׼�Ķ��ַ�
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

	// ��ÿ�����ֵ�Ƚϣ����˾����ƣ�С�˾�����
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
