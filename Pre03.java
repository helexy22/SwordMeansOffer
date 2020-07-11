package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Helexy22
 * @version Time：2020年6月25日 下午10:45:11
 * @Issue:从尾到头打印链表 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 主义最后还是要将ArrayList打印出来
 */
public class Pre03 {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	// ListNode 的首尾交换（旋转）
	public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<>();
		while (listNode != null) {
			result.add(listNode.val);
			listNode = listNode.next;
		}
		for (int i = 0; i < result.size() / 2; i++) {
			int temp = result.get(i);
			result.set(i, result.get(result.size() - i - 1));
			result.set(result.size() - i - 1, temp);
		}
		return result;
	}

	// 借助栈,将 ListNode 用 Stack 存储，push 和 pop
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<ListNode> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode);
			listNode = listNode.next;
		}
		while (stack != null) {
			result.add(stack.pop().val);
		}
		return result;
	}

	// 递归的思想，每一次都是 listNode.next 的再次从尾到头，最终是 result.add(listNode.val
	//	 为了避免每次都要创建ArrayList，所以声明为成员变量
	static ArrayList<Integer> result = new ArrayList<>();

	public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead3(listNode.next);
			result.add(listNode.val);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			ListNode head = new ListNode(input.nextInt());

			// 生成链表
			for (int i = 1; i < n; i++) {
				ListNode node = new ListNode(input.nextInt());
				node.next = head;
				head = node;
			}

			ArrayList<Integer> result1 = printListFromTailToHead1(head);
			for (int item : result1) {
				System.out.print(item + " ");
			}
			System.out.println();

			ArrayList<Integer> result2 = printListFromTailToHead2(head);
			for (int item : result2) {
				System.out.print(item + " ");
			}
			System.out.println();

		}
	}

}
