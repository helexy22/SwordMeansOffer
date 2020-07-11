package SwordMeansOffer;

import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time：2020年6月26日 下午5:19:53
 * @Issue:反转链表 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Pre15 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	static ListNode head;

	// -----用三个辅助指针进行操作，
	// pre 始终指向已反序的最后一个节点
	// middle始终指向正在考察节点
	// after始终指向待反序的第一个节点，也就是middle之后
	public static ListNode ReveseList1(ListNode head) {
		ListNode pre = null;
		ListNode middle = head;
		ListNode after = null;

		while (middle != null) {
			// 反序
			after = middle.next;
			middle.next = pre;
			pre = middle;
			// 后移middle, 换下一个待考察节点
			middle = after;
		}
		return pre;
	}

	// ------充分利用head指针和外加2个辅助指针,仅仅是对1的优化
	public static ListNode ReveseList2(ListNode head) {
		ListNode pre = null;
		ListNode after = null;
		while (head != null) {
			after = head.next;
			head.next = pre;
			pre = head;
			head = after;
		}
		return pre;
	}

	// -----递归实现
	public static ListNode ReveseList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reverseHead = ReveseList3(head.next);
		head.next = head;
		head.next = null;
		return reverseHead;
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
		while(input.hasNext()){
			int n=input.nextInt();
			ListNode head=new ListNode(input.nextInt());
			for (int i = 1; i < n; i++) {
				ListNode node=new ListNode(input.nextInt());
				node.next=head;
				head=node;
			}
			
			System.out.println(toString(head));
			head=ReveseList3(head);
			System.out.println(toString(head));
		}
	}

}
