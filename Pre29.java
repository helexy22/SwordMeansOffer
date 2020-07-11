package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time��2020��6��28�� ����9:26:30
 * @Issue:��С��K���� ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 *               ���ѡ��߼��㷨������
 */
public class Pre29 {

	// -------���������
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (input == null || k <= 0 || k > input.length) {
			return result;
		}
		Arrays.sort(input);
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		return result;
	}

	// -----���ڿ��ŵĻ��ֺ�����˼������
	public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (input == null || k <= 0 || k > input.length) {
			return result;
		}
		findKthValue(input, 0, input.length - 1, k - 1);
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		return result;
	}

	public static void findKthValue(int[] input, int low, int high, int k) {
		// TODO Auto-generated method stub
		if (low < high) {
			int pivot = new Random().nextInt(high - low + 1) + low;
			swap(input, pivot, high);
			int index = low;
			for (int i = low; i < high; i++) {
				if (input[i] < input[high]) {
					swap(input, i, index);
					index++;
				}
			}
			swap(input, index, high);
			if (index > k) {
				findKthValue(input, low, index - 1, k);
			} else if (index < k) {
				findKthValue(input, index + 1, high, k);
			}

		}
	}

	public static void swap(int[] input, int index, int high) {
		// TODO Auto-generated method stub
		int temp = input[index];
		input[index] = input[high];
		input[high] = temp;
	}

	// ------Topk����
	public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (input == null || k <= 0 || k > input.length) {
			return result;
		}
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
			// ��ΪҪ����������������ʹ���Զ���Ƚ������Ƚϲ���Ϊo1����o2ʱ��o1��o2��ǰ��
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});
		for (int i = 0; i < input.length; i++) {
			if (i < k) {
				priorityQueue.add(input[i]);
			} else if (input[i] < priorityQueue.peek()) {
				priorityQueue.poll();
				priorityQueue.add(input[i]);
			}
		}
		result.addAll(priorityQueue);
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = input.nextInt();
			}
			int k = input.nextInt();
			ArrayList<Integer> result = GetLeastNumbers_Solution3(nums, k);
			for (int item : result) {
				System.out.println(item + " ");
			}
			System.out.println();
		}
	}
}
