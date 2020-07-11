package SwordMeansOffer;
/**
* @author Helexy22
* @version Time：2020年7月1日 下午4:15:54
* @Issue:删除链表中重复的节点
* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
* 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
		//添加头节点
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
