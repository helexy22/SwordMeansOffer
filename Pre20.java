package SwordMeansOffer;

import java.util.Stack;

/**
 * @author Helexy22
 * @version Time：2020年6月27日 上午9:39:07
 * @Issue:包含min函数的栈 较难 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *       注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class Pre20 {

	// 数据栈
	static Stack<Integer> data = new Stack<>();
	// 辅助栈
	static Stack<Integer> minData = new Stack<>();

	public static void push(int node) {
		data.push(node);
		if (minData.isEmpty()) {
			minData.push(node);
		} else {
			// 保证 minData 栈顶始终是最小值
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
