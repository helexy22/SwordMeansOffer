package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
* @author Helexy22
* @version Time��2020��7��2�� ����10:15:37
* @Issue:��֮����˳���ӡ������
* ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
* �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
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
