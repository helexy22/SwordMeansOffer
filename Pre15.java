package SwordMeansOffer;

import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time��2020��6��26�� ����5:19:53
 * @Issue:��ת���� ����һ��������ת��������������ı�ͷ��
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

	// -----����������ָ����в�����
	// pre ʼ��ָ���ѷ�������һ���ڵ�
	// middleʼ��ָ�����ڿ���ڵ�
	// afterʼ��ָ�������ĵ�һ���ڵ㣬Ҳ����middle֮��
	public static ListNode ReveseList1(ListNode head) {
		ListNode pre = null;
		ListNode middle = head;
		ListNode after = null;

		while (middle != null) {
			// ����
			after = middle.next;
			middle.next = pre;
			pre = middle;
			// ����middle, ����һ��������ڵ�
			middle = after;
		}
		return pre;
	}

	// ------�������headָ������2������ָ��,�����Ƕ�1���Ż�
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

	// -----�ݹ�ʵ��
	public static ListNode ReveseList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reverseHead = ReveseList3(head.next);
		head.next = head;
		head.next = null;
		return reverseHead;
	}

	// ��ӡ����
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
