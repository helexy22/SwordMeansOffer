package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��6��26�� ����8:30:19
* @Issue:�����ӽṹ
* �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
*/
public class Pre17 {

	//��׼������ �������ݽṹ
	static class TreeNode{
		int val=0;
		TreeNode left=null;
		TreeNode right=null;
		public TreeNode(int val){
			this.val=val;
		}
	}
	
	//�����в���Ҫ����CA��׼������ hasSubTree ������еĺ���
	//*****���н϶�ĵݹ�ݹ��÷�
	//-----������1��Ѱ������2���ڵ���ͬ�Ľڵ㣬���ж���root1Ϊ���������Ƿ�����root2Ϊ����������ͬ
	//����1��Ѱ������2���ڵ���ͬ�Ľڵ�
	public static boolean hasSubTree(TreeNode root1,TreeNode root2) {
		boolean result=false;
		if (root1!=null&&root2!=null) {
			if (root1.val==root2.val) {
				result=doesTree1HavaTree2(root1,root2);
			}
			if (!result) {
				result=hasSubTree(root1.left,root2);
			}
			if (!result) {
				result=hasSubTree(root1.right,root2);
			}
		}
		return result;
	}
	
	//�ж���root1Ϊ���������Ƿ�����root2Ϊ����������ͬ
	public static boolean doesTree1HavaTree2(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return true;
		}
		if (root1==null) {
			return false;
		}
		if (root1.val!=root2.val) {
			return false;
		}
		//���������������
		return doesTree1HavaTree2(root1.left,root2.left)&&
				 doesTree1HavaTree2(root1.right,root2.right);
	}
	
	
}
