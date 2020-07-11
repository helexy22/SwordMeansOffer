package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月27日 下午3:46:13
* @Issue:二叉搜索树的后续遍历序列
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
public class Pre23 {

	public static boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence==null||sequence.length==0) {
			return false;
		}
		return VerifySquenceOfBST(sequence,0,sequence.length-1);
	}
	
	//-------递归判断当前树结构的后序遍历是否满足二叉搜索
	public static boolean VerifySquenceOfBST(int[] sequence,int start,int root) {
		if(start>=root) {
			return true;
		}
		int indexOfRightRoot=start;
		
		//右子树的根节点
		while (indexOfRightRoot<root&&sequence[indexOfRightRoot]<=sequence[root]) {
			indexOfRightRoot++;
		}
		//判断右子树是否全部大于根节点
		for (int i = indexOfRightRoot; i < root; i++) {
			if (sequence[i]<sequence[root]) {
				return false;
			}
		}
		
		 //递归判断左右子树
		return VerifySquenceOfBST(sequence,start,indexOfRightRoot-1)&&
				VerifySquenceOfBST(sequence,indexOfRightRoot,root-1);
	}
	
	//------非递归实现
	public static boolean VerifySquenceOfBST2(int[] sequence) {
		if (sequence==null||sequence.length==0) {
			return false;
		}
		int index=0;
		int size=sequence.length;
		while (--size>0) {
			//找到右子树第一个节点
			while (sequence[index]<sequence[size]) {
				index++;
			}
			//判断右子树是否满足规定
			while (index<size&&sequence[index++]>sequence[size]) {
				if (index<size) {
					return false;
				}
				index=0;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 while (input.hasNext()) {
			int n=input.nextInt();
			int[] sequence=new int[n];
			for (int i = 0; i <n; i++) {
				sequence[i]=input.nextInt();
			}
			System.out.println(VerifySquenceOfBST(sequence));
		}
	}
}
