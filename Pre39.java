package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��6��28�� ����9:03:14
* @Issue:	ƽ�������
* ����һ�ö��������жϸö������Ƿ���ƽ���������
* ���������ֻ��Ҫ������ƽ���ԣ�����Ҫ�������ǲ������������
*/
public class Pre39 {

	public static class TreeNode{
		int val=0;
		TreeNode left=null;
		TreeNode right=null;
		
		public TreeNode(int val) {
			this.val=val;
		}
	}
	
	
	public int TreeDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = TreeDepth(node.left);
		int right = TreeDepth(node.right);
		return Math.max(left, right) + 1;
	}
	 
	public  boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return false;
		}
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right)
				&& Math.abs(TreeDepth(root.right) - TreeDepth(root.left)) < 2;
	}
	
	static boolean isBalance=true;
	
	//�� static
	public  static boolean ISBanlance_Solution2(TreeNode root) {
		if (root == null) {
			return true;
		}
		isBalance=true;
		caculateBalanceTree(root);
		return isBalance;
		
	}

	private static int caculateBalanceTree(TreeNode node) {
		// TODO Auto-generated method stub
		if (node==null||!isBalance) {
			return 0;
		}
		int left=caculateBalanceTree(node.left);
		int right=caculateBalanceTree(node.right);
		isBalance=Math.abs(left-right)<2?true:false;
		return Math.max(left,right)+1;
	}
	
	public static class DepthHolder {
		int depth;
	}
	
	public static boolean IsBalance_Solution3(TreeNode root) {
		if (root == null) {
			return true;
		}
		DepthHolder depthhodler=new DepthHolder();
		return isBalance(root,depthhodler);
		
	}

	private static boolean isBalance(TreeNode node, DepthHolder depthHodler) {
		// TODO Auto-generated method stub
		if (node==null) {
			depthHodler.depth=0;
			return true;
		}
		DepthHolder leftDepthHolder = new DepthHolder(), rightDepthHolder = new DepthHolder();
		if (isBalance(node.left,leftDepthHolder)&&isBalance(node.right,leftDepthHolder)) {
			if (Math.abs(leftDepthHolder.depth-leftDepthHolder.depth)<2) {
				depthHodler.depth=Math.max(leftDepthHolder.depth,rightDepthHolder.depth)+1;
				return true;
			}
		}
		return true;
	}
}
