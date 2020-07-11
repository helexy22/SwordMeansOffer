package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Helexy22
 * @version Time��2020��6��25�� ����10:45:11
 * @Issue:��β��ͷ��ӡ���� ����һ�������������β��ͷ��˳�򷵻�һ��ArrayList��
 * ���������Ҫ��ArrayList��ӡ����
 */
public class Pre03 {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	// ListNode ����β��������ת��
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

	// ����ջ,�� ListNode �� Stack �洢��push �� pop
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

	// �ݹ��˼�룬ÿһ�ζ��� listNode.next ���ٴδ�β��ͷ�������� result.add(listNode.val
	//	 Ϊ�˱���ÿ�ζ�Ҫ����ArrayList����������Ϊ��Ա����
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

			// ��������
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
