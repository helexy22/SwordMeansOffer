package SwordMeansOffer;

import java.util.Stack;

/**
 * @author Helexy22
 * @version Time��2020��6��27�� ����9:39:07
 * @Issue:����min������ջ ���� ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 *       ע�⣺��֤�����в��ᵱջΪ�յ�ʱ�򣬶�ջ����pop()����min()����top()������
 */
public class Pre20 {

	// ����ջ
	static Stack<Integer> data = new Stack<>();
	// ����ջ
	static Stack<Integer> minData = new Stack<>();

	public static void push(int node) {
		data.push(node);
		if (minData.isEmpty()) {
			minData.push(node);
		} else {
			// ��֤ minData ջ��ʼ������Сֵ
			minData.push(Math.min(node, minData.peek()));
		}
	}

	public static void pop() {
		if (data.size() == 0) {
			throw new RuntimeException("Stack is empty");
		}
		data.pop();
		minData.pop();
	}

	public static int top() {
		return data.peek();
	}

	public static int min() {
		return minData.peek();
	}

	public static void main(String[] args) {
		push(3);
		push(4);
		push(2);
		push(1);
		pop();
		pop();
		push(0);
	}

}
