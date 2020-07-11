package SwordMeansOffer;

import java.util.List;

/**
* @author Helexy22
* @version Time：2020年7月2日 上午9:32:19
* @Issue:二叉树的下一个结点
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
	
	//------------纯递归中序遍历二叉树
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
	
//	//------：变形的中序遍历，可中断
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
