package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
* @author Helexy22
* @version Time��2020��6��27�� ����4:12:21
* @Issue:�������к�Ϊĳһֵ��·��
* ����һ�Ŷ������ĸ��ڵ��һ�����������ֵ����ӡ���������н��ֵ�ĺ�Ϊ��������������·����
* ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
*/
public class Pre24 {
	
	static class TreeNode{
		int val=0;
		TreeNode left=null;
		TreeNode right=null;
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if (root==null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(root.val);
		
		//��̬
		FindPath(result,temp,root.val,root,target);
		return result;
	}

	/**
     * dfs������ʽ�����ǵĸ��ڵ��Ѿ��ڱ���ǰ����
     * @param result ���Ľ��
     * @param temp   ��ǰ��·��
     * @param sum    ��ǰ�ĺ�
     * @param node   ·�������һ���ڵ�
     * @param target Ŀ��ֵ
     */
	private static void FindPath(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int sum, TreeNode node,int target) {
		// TODO Auto-generated method stub
		/*
		 * �ж��Ƿ��·�������һ���ڵ��Ƿ���Ҷ�ӽڵ� 
		 * ���ǣ��жϸ�·���ĺ��Ƿ����target 
		 * �����ڣ��Ѹ�·������·������
		 */
		if (node.left==null&&node.right==null&&sum==target) {
			ArrayList<Integer> path = new ArrayList<>();
			path.addAll(temp);
			result.add(new ArrayList<>(temp));
			return;
		}
		//�����õ�������
		if (node.left!=null) {
			temp.add(node.left.val);
			FindPath(result,temp,sum+node.left.val,node.left,target);
			
			//����
			temp.remove(temp.size()-1);
		}
		//�����õ��������
		if (node.right!=null) {
			temp.add(node.right.val);
			FindPath(result,temp,sum+node.right.val,node.right,target);
			//����
			temp.remove(temp.size()-1);
		}
	}
	
	//------
	public static ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
		if (root==null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> temp=new ArrayList<>();
		FindPath2(result,temp,0,root,target);
		return result;
	}
	
	/**
     * ���ö��������������֪ʶ����
     * ÿ�ζ��Ը��ڵ㴦��
     * @param result
     * @param temp
     * @param sum
     * @param node
     * @param target
     */

	private static void FindPath2(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int sum, TreeNode node,
			int target) {
		// TODO Auto-generated method stub
		temp.add(node.val);
		sum+=node.val;
		if (node.left==null&&node.right==null&&sum==target) {
			ArrayList<Integer> path = new ArrayList<>();
			path.addAll(temp);
			result.add(new ArrayList<>(temp));
			return;
		}
		//�����õ�������
		if (node.left!=null) {
			FindPath2(result,temp,sum,node.left,target);
		}
		if (node.right!=null) {
			FindPath2(result,temp,sum,node.right,target);
		}
		temp.remove(temp.size()-10);
	}
	
	
	//----�ǵݹ�ʵ��
	/**
     * �ǵݹ�ʵ�֣�����last����Ϊ��һ�α����Ľ�㡣
     * ��Ϊ����ʱ������������ݵ����ڵ��ϣ�����ͨ��last��ȷ���������Ƿ��Ѿ�����
     * @param root
     * @param target
     * @return
     */
	
	public static ArrayList<ArrayList<Integer>> FindPath3(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root==null) {
			return result;
		}
		ArrayList<Integer> temp = new ArrayList<>();
		TreeNode cur=root,last=null;
		Stack<TreeNode> stack = new Stack<>();
		int sum=0;
		while (cur!=null||!stack.isEmpty()) {
			if (cur==null) {
				TreeNode top=stack.peek();
				if (top.right!=null&&top.right!=last) {
					cur=top.right;
				}else {
					last=top;
					stack.pop();
					temp.remove(temp.size()-1);
					sum-=last.val;
				}
			}else {
				stack.push(cur);
				temp.add(cur.val);
				sum+=cur.val;
				if (cur.left==null&&cur.right==null&&sum==target) {
					result.add(new ArrayList<>(temp));
				}
				cur=cur.left;
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
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			str=input.next();
			index=0;
			TreeNode root=buildTree();
			int target=input.nextInt();
			ArrayList<ArrayList<Integer>> result=FindPath(root,target);
			for (ArrayList<Integer> item : result) {
				System.out.println(item.toString());
			}
			System.out.println();
			
		}
	}
	
}
