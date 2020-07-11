package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
* @author Helexy22
* @version Time：2020年7月2日 上午10:15:37
* @Issue:按之字形顺序打印二叉树
* 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
* 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/
public class Pre59 {
	
	public class TreeNode{
		int val=0;
		TreeNode left=null;
		TreeNode right=null;
		
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (pRoot==null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		int index=0;
		while (!queue.isEmpty()) {
			index++;
			int length=queue.size();
			ArrayList<Integer> row = new ArrayList<>();
			for (int i = 0; i < length; i++) {
				TreeNode node=queue.poll();
				row.add(node.val);
				if (node.left!=null) {
					queue.add(node.left);
				}
				if (node.right!=null) {
					queue.add(node.right);
				}
			}
			if ((index&1)==0) {
				Collections.reverse(row);
			}
			result.add(row);
		}
		return result;
	}
}
