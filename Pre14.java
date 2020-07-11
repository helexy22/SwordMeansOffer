package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����4:24:19
* @Issue:�����е�����k���ڵ�
* ����һ����������������е�����k����㡣
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
	
	//------˫ָ�룬һ������k-1����Ȼ����һ���ߣ����ڶ�ָ���ߵ�nλʱ����һ��ָ������ָ��(n - k+1)λ��
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
				return null;//k���
			}
		}
		//�����ڵ����k-1������p�ߵ�β��ʱ��p���õ��� n-k+1��λ��(������k��λ��)
		while(p!=null) {
			q=q.next;
			p=p.next;
		}
		return q;
	}
	
	//-----ԭ����1һ�������ǹ����Ż�����kʱ��q��ʼ�ƶ�
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
	
	//��ӡ����
	public static String toString(ListNode p) {
		StringBuilder sb = new StringBuilder();
		while (p!=null) {
			sb.append(p.val);
			sb.append(" ");
			p=p.next;
		}
		return sb.toString();
	}
	
	//���������������Ѱ��������м�ڵ㡢�жϵ������Ƿ��л������������ĳһ���ָ�롭��
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n=input.nextInt();
			ListNode head = new ListNode(input.nextInt());
			
			//ͷ�巨��������
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