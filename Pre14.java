package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月26日 下午4:24:19
* @Issue:链表中倒数第k个节点
* 输入一个链表，输出该链表中倒数第k个结点。
*/
public class Pre14 {
	
	static class ListNode{
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val=val;
		}
	}
	
	static ListNode head;
	
	//------双指针，一个先走k-1步，然后再一起走，当第二指针走到n位时，第一个指针正好指向(n - k+1)位置
	public static ListNode FindKthToTail1(ListNode head,int k) {
		if(head==null||k<=0) {
			return null;
		}
		ListNode q=head;
		ListNode p=head;
		for (int i = 0; i < k; i++) {
			if(p!=null) {
				p=p.next;
			}else {
				return null;//k溢出
			}
		}
		//两个节点相差k-1步，当p走到尾端时，p正好到达 n-k+1的位置(倒数第k个位置)
		while(p!=null) {
			q=q.next;
			p=p.next;
		}
		return q;
	}
	
	//-----原理与1一样，但是过程优化，从k时，q开始移动
	public static ListNode FindKthToTail2(ListNode head,int k) {
		if (head==null||k<=0) {
			return null;
		}
		ListNode q=head;
		ListNode p=head;
		int i=0;
		for (;p!=null;i++) {
			if(i>=k) {
				q=q.next;
			}
			p=p.next;
		}
		return i<k?null:q;
	}
	
	//打印链表
	public static String toString(ListNode p) {
		StringBuilder sb = new StringBuilder();
		while (p!=null) {
			sb.append(p.val);
			sb.append(" ");
			p=p.next;
		}
		return sb.toString();
	}
	
	//链表的其他操作：寻找链表的中间节点、判断单链表是否有环、获得链表中某一项的指针……
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n=input.nextInt();
			ListNode head = new ListNode(input.nextInt());
			
			//头插法生成链表
			for (int i = 1; i < n; i++) {
				ListNode node=new ListNode(input.nextInt());
				node.next=head;
				head=node;
			}
			
			System.out.println(toString(head));
			
			ListNode result=FindKthToTail1(head,5);
			System.out.println(toString(result));
		}
	}

}