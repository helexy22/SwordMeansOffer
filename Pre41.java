package SwordMeansOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月29日 上午9:47:51
* @Issue:和为S的连续正数序列
* 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
* 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
* 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
* 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
* 输出描述:
* 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
* 双指针、数组
*/
public class Pre41 {

	//------
	public static ArrayList<ArrayList<Integer>> FindContinuousSequece(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (sum==1) {
			return result;
		}
		//定义指针宽度
		ArrayList<Integer> temp = new ArrayList<>();
		int tempSum=0;
		//最短宽度为2，并且有边界最多达到sum/2(因为sum/2+sum/2+1)
		int mid=(sum+1)/2;
		for (int i = 1; i < mid; i++) {
			tempSum+=i;
			temp.add(i);
			
			//如果大于，就持续砍掉左边，然后再右移
			if (tempSum > sum) {
				// 去掉序列第一个,直到不大于
				while (tempSum > sum) {
					tempSum -= temp.get(0);
					temp.remove(0);
				}
				
			}
			if (tempSum==sum) {
				ArrayList<Integer> item = new ArrayList<>();
				for (int t : item) {
					item.add(t);
				}
				result.add(item);
				tempSum-=temp.get(0);
				temp.remove(0);
			}
		}
		return result;
	}
	
	//--------
	public static ArrayList<ArrayList<Integer>> FindContinuousSequece2(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (sum<=2) {
			return result;
		}
		int left=1,right=2,tempSum=3;
		while (left<right) {
			if (tempSum<sum) {
				right++;
				tempSum+=right;
			}else if (tempSum>sum) {
				tempSum-=left;
				left++;
			}else {
				ArrayList<Integer> temp = new ArrayList<>();
				for (int i = left; i <=right; i++) {
					temp.add(i);
				}
				tempSum-=left;
				left++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int sum=input.nextInt();
			List<ArrayList<Integer>> result=FindContinuousSequece2(sum);
			for (ArrayList<Integer> item : result) {
				for (int i : item) {
					System.out.println(i+" ");
				}
			}
		}
	}
}
