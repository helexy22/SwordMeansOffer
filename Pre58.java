package SwordMeansOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
* @author Helexy22
* @version Time：2020年7月2日 上午9:57:46
* @Issue:	把二叉树打印成多行
* 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/
public class Pre58 {
	
	public class TreeNode{
		int val=0;
		TreeNode left=null;
		TreeNode right=null;
		
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	//-----方法一：每次循环时确保队列中仅含当前层节点
	ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (pRoot==null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			ArrayList<Integer> row = new ArrayList<>();
			int length=queue.size();
			for (int i = 0; i < length; i++) {
				TreeNode node=queue.poll();
				row.add(node.val);
				if (node.left!=null) {
					queue.offer(node.left);
				}
				if (node.right!=null) {
					queue.offer(node.right);
				}
			}
			result.add(row);
		}
		return result;
	}
	
	//-----双指针
	ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (pRoot==null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		TreeNode last=pRoot,nLast=pRoot;
		ArrayList<Integer> row = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode node=queue.poll();
			row.add(node.val);
			if (node.left!=null) {
				queue.offer(node.left);
				nLast=node.left;
			}
			if (node.right!=null) {
				queue.offer(node.right);
				nLast=node.right;
			}
			if (node==last) {
				result.add(row);
				row=new ArrayList<>();
				last=nLast;
			}
		}
		return result;
	}
	
}
