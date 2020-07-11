package SwordMeansOffer;

import java.util.Scanner;


/**
 * @author Helexy22
 * @version Time：2020年6月26日 下午5:40:51
 * @Issue:合并两个排序的链表 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Pre16 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	static ListNode head1;
	static ListNode head2;

	public static ListNode Merge1(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode head = null;
		if (list1.val <= list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}

		ListNode p = head;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				p.next = list1;
				p = p.next;
				list1 = list1.next;
			} else {
				p.next = list2;
				p = p.next;
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			p.next = list2;
		}
		if (list2 == null) {
			p.next = list1;
		}
		return head;
	}

	// ----递归实现
	public static ListNode Merge2(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val <= list2.val) {
			list1.next = Merge2(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge2(list1, list2.next);
			return list2;
		}
	}

	// 打印链表
	public static String toString(ListNode p) {
		StringBuilder sb = new StringBuilder();
		while (p != null) {
			sb.append(p.val);
			sb.append(" ");
			p = p.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			head1 = new ListNode(input.nextInt());
			for (int i = 1; i < n; i++) {
				ListNode node = new ListNode(input.nextInt());
				node.next = head1;
				head1 = node;
			}

			n = input.nextInt();
			head2 = new ListNode(input.nextInt());
			for (int i = 1; i < n; i++) {
				ListNode node = new ListNode(input.nextInt());
				node.next = head2;
				head2 = node;
			}

			System.out.println(toString(head1));
			System.out.println(toString(head2));
			ListNode result = Merge1(head1, head2);
			System.out.println(toString(result));
		}
	}
}
