package SwordMeansOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��27�� ����10:27:15
* @Issue:�������´�ӡ������
* �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
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
	
	
	//����ǰ�����л�����������
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
	
	//ǰ�����������
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
