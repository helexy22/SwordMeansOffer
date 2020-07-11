package SwordMeansOffer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Helexy22
 * @version Time：2020年6月27日 上午9:50:12
 * @Issue:栈的压入、弹出序列 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *                  假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Pre21 {

	// -----以弹出序列为主
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

	// -----以压入序列为主,思路清晰，代码简单，推荐这个解法
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
