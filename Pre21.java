package SwordMeansOffer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Helexy22
 * @version Time��2020��6��27�� ����9:50:12
 * @Issue:ջ��ѹ�롢�������� ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 *                  ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class Pre21 {

	// -----�Ե�������Ϊ��
	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null) {
			return false;
		}
		int indexPush = 0;
		int indexPop = 0;
		Stack<Integer> stack = new Stack<>();
		boolean isPopOrder = true;
		while (indexPop < popA.length) {
			while (stack.isEmpty() || (indexPush < pushA.length && stack.peek() != popA[indexPop])) {
				stack.push(pushA[indexPush++]);
			}

			if (stack.peek() != popA[indexPop]) {
				isPopOrder = false;
				break;
			}
			stack.pop();
			indexPop++;
		}
		return isPopOrder;
	}

	// -----��ѹ������Ϊ��,˼·����������򵥣��Ƽ�����ⷨ
	public static boolean IsPopOrder2(int[] pushA, int[] popA) {
		if (pushA == null || popA == null) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int indexPop = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[indexPop]) {
				stack.pop();
				indexPop++;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int[] push = new int[n];
			int[] pop = new int[n];
			for (int i = 0; i < n; i++) {
				push[i] = input.nextInt();
			}
			for (int i = 0; i < n; i++) {
				pop[i] = input.nextInt();
			}
			System.out.println(IsPopOrder(push, pop));
		}
	}

}
