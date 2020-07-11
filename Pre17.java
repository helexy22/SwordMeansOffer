package SwordMeansOffer;
/**
* @author Helexy22
* @version Time：2020年6月26日 下午8:30:19
* @Issue:树的子结构
* 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
*/
public class Pre17 {

	//标准化流程 树的数据结构
	static class TreeNode{
		int val=0;
		TreeNode left=null;
		TreeNode right=null;
		public TreeNode(int val){
			this.val=val;
		}
	}
	
	//本题中不需要进行CA标准化输入 hasSubTree 是题解中的函数
	//*****含有较多的递归递归用法
	//-----先在树1中寻找与树2根节点相同的节点，再判断以root1为根的子树是否与以root2为根的子树相同
	//在树1中寻找与树2根节点相同的节点
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
	
	//判断以root1为根的子树是否与以root2为根的子树相同
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
		//左数和右树都相等
		return doesTree1HavaTree2(root1.left,root2.left)&&
				 doesTree1HavaTree2(root1.right,root2.right);
	}
	
	
}
