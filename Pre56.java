package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��7��1�� ����4:15:54
* @Issue:ɾ���������ظ��Ľڵ�
* ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 
* ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
*/
public class Pre56 {
	public class ListNode{
		int val;
		ListNode next=null;
		
		ListNode(int val){
			this.val=val;
		}
	}
	
	public ListNode deleteDuplication (ListNode pHead) {
		if (pHead==null||pHead.next==null) {
			return pHead;
		}
		//���ͷ�ڵ�
		ListNode head = new ListNode(0);
		head.next=pHead;
		ListNode p=head;
		ListNode s=pHead;
		ListNode d=pHead.next;
		while (d!=null) {
			if (s.val!=d.val) {
				if (s.next==d) {
					p.next=s;
					p=p.next;
				}
				s=d;
				d=d.next;
			}else {
				d=d.next;
			}
			
		}
		p.next=s.next==null?s:null;
		return head.next;
	}
}	
