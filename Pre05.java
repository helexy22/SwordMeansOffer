package SwordMeansOffer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Helexy22
 * @version Time：2020年6月26日 上午9:38:42
 * @Issue:用两个栈实现队列 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Pre05 {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop(int node) {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		if (stack2.isEmpty()) {
			while (stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Pre05 test = new Pre05();
		while (input.hasNext()) {
			int n = input.nextInt();
			for (int i = 0; i < n; i++) {
				test.push(i);
			}
			for (int i = 0; i < n; i++) {
				System.out.println(test.pop(i) + " ");
			}
			System.out.println();
		}
	}

}
