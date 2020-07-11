package SwordMeansOffer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Helexy22
 * @version Time��2020��6��26�� ����9:38:42
 * @Issue:������ջʵ�ֶ��� ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
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
