package SwordMeansOffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Helexy22
 * @version Time��2020��6��25�� ����11:22:05
 * @Issue:�ؽ��������� ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 *               ���������ǰ���������������Ľ���ж������ظ������֡���������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */
public class Pre04 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// ��ʶǰ��������λ��
	static int index;

	public static TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
		index = 0;
		int length = pre.length;
		return reConstructBinaryTree(pre, in, 0, length - 1);

	}

	/*
	 * �ݹ��ʵ���ؽ�������
	 * 
	 * @param pre
	 * @param in
	 * @param s �ؽ�����Ŀ�ʼλ�ã�inclusive
	 * @param e �ؽ�����Ľ���λ�ã�inclusive
	 * @return
	 */
	private static TreeNode reConstructBinaryTree(int[] pre, int[] in, int s, int e) {
		TreeNode treeNode = null;
		if (s <= e) {
			treeNode = new TreeNode(pre[index]);

			int i = getiByVal(pre[index++], in, s, e);

			treeNode.left = reConstructBinaryTree(pre, in, s, i - 1);

			treeNode.right = reConstructBinaryTree(pre, in, i + 1, e);
		}
		return treeNode;
	}

	/*
	 **
	 * ��ø��ڵ������������λ�� ���Ӷ�Ϊ���ԣ���Ȼ��������ù�ϣ
	 * @param target
	 * @param in
	 * @return
	 */
	private static int getiByVal(int target, int[] in, int s, int e) {
		for (int i = s; i <= e; i++) {
			if (target == in[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * ��������
	 * @param pre
	 * @param in
	 * @return
	 */
	public static TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode treeNode = new TreeNode(pre[0]);
		for (int i = 0; i < in.length; i++) {
			if (pre[0] == in[i]) {
				treeNode.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));

				treeNode.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));

				break;
			}
		}
		return treeNode;
	}

	/**
	 * �ݹ���ǰ����������� ���ڼ��鹹�������Ƿ���ȷ
	 * @param treeNode
	 */
	static void preTraverse(TreeNode treeNode) {
		if (treeNode != null) {
			System.out.println(treeNode.val + " ");
			preTraverse(treeNode.left);
			preTraverse(treeNode.right);
		}
	}

	public static void main(String[] args) {

		// ��׼����
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int[] pre = new int[n];
			int[] in = new int[n];

			for (int i = 0; i < n; i++) {
				pre[i] = input.nextInt();
			}
			for (int i = 0; i < n; i++) {
				in[i] = input.nextInt();
			}

			////
			TreeNode root = reConstructBinaryTree1(pre, in);
			preTraverse(root);
			System.out.println();

			////
			root = reConstructBinaryTree2(pre, in);
			preTraverse(root);
			System.out.println();
		}
	}

}
