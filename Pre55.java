package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��7��1�� ����3:46:46
* @Issue:�����л�����ڽ��
* ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
*/
public class Pre55 {

	public class ListNode{
		int val;
		ListNode next=null;
		
		ListNode(int val){
			this.val=val;
		}
	}
	
	//-------��ѧ֤����---�ó��Ľ���
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead==null||pHead.next==null) {
			return null;
		}
		boolean isIntersct=true;
		ListNode p=pHead;
		ListNode q=pHead;
		while (q!=null&&q.next!=null) {
			p=p.next;
			q=q.next.next;
			if (p==q) {
				break;
			}
		}
		isIntersct=p==q?true:false;
		if (isIntersct) {
			p=pHead;
			while (p!=q) {
				p=p.next;
				q=q.next;
			}
			return p;
		}else {
			return null;
		}
	}
	
	//--------���û�����EntryNodeOfLoop2
	public ListNode EntryNodeOfLoop2(ListNode pHead) {
		if (pHead==null||pHead.next==null) {
			return null;
		}
		boolean isIntersct=true;
		ListNode p=pHead;
		ListNode q=pHead;
		while (q!=null&&q.next!=null) {
			p=p.next;
			q=q.next.next;
			if (p==q) {
				break;
			}
		}
		isIntersct=p==q?true:false;
		if (isIntersct) {
			int circleLength=caculateCircleLength(q);
			System.out.println(circleLength);
			q=pHead;
			while (circleLength-->0) {
				q=q.next;
			}
			p=pHead;
			while (p!=q) {
				p=p.next;
				q=q.next;
			}
			return p;
		}else {
			return null;
		}
	}

	//���㻷��
	public int caculateCircleLength(ListNode node) {
		// TODO Auto-generated method stub
		ListNode start=node;
		int length=0;
		do {
			length++;
			node=node.next;
		} while (node!=start);
		return length;
	}
	
	public ListNode insert(ListNode pHead, ListNode node) {
        node.next = pHead;
        return node;
    }
	
	public void printList(ListNode pHead) {
        while(pHead != null) {
            System.out.print(pHead.val + " ");
            pHead = pHead.next;
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		   Pre55 pro67 = new Pre55();
	        ListNode pHead = null;
	        for(int i = 4; i > 0; i--) {
	            pHead = pro67.insert(pHead, pro67.new ListNode(i));
	        }
	        pro67.printList(pHead);
	        pHead.next.next.next.next = pHead.next;
	        System.out.println(pro67.EntryNodeOfLoop2(pHead).val);
	}
}
