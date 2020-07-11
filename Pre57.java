package SwordMeansOffer;

import java.util.List;

/**
* @author Helexy22
* @version Time��2020��7��2�� ����9:32:19
* @Issue:����������һ�����
* ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
* ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
*/
public class Pre57 {
	public class TreeLinkNode{
		int val;
		TreeLinkNode left=null;
		TreeLinkNode right=null;
		TreeLinkNode next=null;
		
		TreeLinkNode(int val){
			this.val=val;
		}
	}
	
	//------------���ݹ��������������
	static List<TreeLinkNode> lists=null;
	
	public TreeLinkNode GetNext1(TreeLinkNode pNode) {
		TreeLinkNode root=getRootNoe(pNode);
		inorderTraversal(root);
		int index=0;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i)==pNode) {
				index=i+1;
				break;
			}
		}
		return index<lists.size()?lists.get(index):null;
	}

	private static void inorderTraversal(TreeLinkNode node) {
		// TODO Auto-generated method stub
		if (node!=null) {
			inorderTraversal(node.left);
			lists.add(node);
			inorderTraversal(node.right);
		}
	}

	public  TreeLinkNode getRootNoe(TreeLinkNode pNode) {
		// TODO Auto-generated method stub
		while (pNode!=null) {
			if (pNode.next==null) {
				return pNode;
			}
			pNode=pNode.next;
		}
		return null;
	}
	
//	//------�����ε�������������ж�
//	static TreeLinkNode nextNode=null;
//	static boolean flag=false;
//	static boolean findFlag=false;
//	
//	public TreeLinkNode GetNext2(TreeLinkNode pNode) {
//		TreeLinkNode root=getRootNode(pNode);
//		nextNode=null;
//		flag=false;
//		findFlag=false;
//		findNextNode1(root,pNode);
//		return nextNode;
//	}
//
//	private TreeLinkNode getRootNode(TreeLinkNode pNode) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void findNextNode1(TreeLinkNode node, TreeLinkNode pNode) {
//		// TODO Auto-generated method stub
//		if (node!=null&&!findFlag) {
//			findNextNode1(node.left,pNode);
//			if (flag) {
//				nextNode=node;
//				findFlag=true;
//			}else if (node==pNode) {
//				flag=true;
//			}
//			findNextNode1(node.right,pNode);
//		}
//	}
	
	
	
	
	
}
