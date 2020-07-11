package SwordMeansOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月27日 上午10:27:15
* @Issue:从上往下打印二叉树
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
*/
public class Pre22 {
	
	static class TreeNode{
		int val=0;
		TreeNode left=null;
		TreeNode right=null;
		
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	//------
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root==null) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node=queue.poll();
			result.add(node.val);
			if (node.left!=null) {
				queue.offer(node.left);
			}
			if (node.right!=null) {
				queue.offer(node.right);
			}
		}
		return result;
	}
	
	
	//根据前序序列化构建二叉树
	static String str;
	static int index;

	public static TreeNode buildTree() {
		if (index>=str.length()) {
			return null;
		}
		char ch=str.charAt(index);
		if (ch=='#') {
			return null;
		}else {
			TreeNode node=new TreeNode(Integer.valueOf(String.valueOf(ch)));
			index++;
			node.left=buildTree();
			index++;
			node.right=buildTree();
			return node;
		}
	}
	
	//前序遍历二叉树
	static StringBuilder sb;
	public static void preOrder(TreeNode node) {
		if (node!=null) {
			sb.append(node.val);
			preOrder(node.left);
			preOrder(node.right);
		}else {
			sb.append('#');
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			str =input.next();
			index=0;
			TreeNode root=buildTree();
			sb=new StringBuilder();
			ArrayList<Integer> result=PrintFromTopToBottom(root);
			for (int item : result) {
				System.out.println(item+" ");
			}
			System.out.println();
		}
	}
	
}
