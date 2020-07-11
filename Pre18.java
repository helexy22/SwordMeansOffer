package SwordMeansOffer;

import java.util.Scanner;
import java.util.Stack;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����8:47:08
* @Issue:�������ľ���
* ���������Ķ�����������任ΪԴ�������ľ���
*/
public class Pre18 {
	
	static class TreeNode{
		int val;
		TreeNode left=null;
		TreeNode right=null;
		
		public TreeNode(int val) {
			this.val=val;
		}
		
	}
	
	//------- �ݹ�ʵ��
	public static void	 Mirror1(TreeNode root) {
		if (root!=null) {
			TreeNode temp=root.left;
			root.left=root.right;
			root.right=temp;
			Mirror1(root.left);
			Mirror1(root.right);
		}
	}
	
	//---------�ǵݹ�ʵ��, ����ջ�����б��������ÿһ����Ҷ�ӽڵ�,������������������
	public static void Mirror2(TreeNode root) {
		if (root==null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node=stack.pop();
			TreeNode temp=node.left;
			node.left=node.right;
			node.right=temp;
			if (node.left!=null) {
				stack.push(node.left);
			}
			if (node.right!=null) {
				stack.push(node.right);
			}
		}
	}
	
	//����ǰ�����л�����������
	static int index;
	static String str;
	public static TreeNode buildTree() {
		if(index>=str.length()) {
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
		if(node!=null) {
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
			str=input.next();
			index=0;
			TreeNode root=buildTree();
			sb=new StringBuilder();
			preOrder(root);
			System.out.println(sb.toString());
			Mirror1(root);
			sb.delete(0,sb.length());
			preOrder(root);
			System.out.println(sb.toString());
		}
	}

}
