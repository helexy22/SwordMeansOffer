package SwordMeansOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��29�� ����9:47:51
* @Issue:��ΪS��������������
* С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
* ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
* û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
* ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
* �������:
* ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
* ˫ָ�롢����
*/
public class Pre41 {

	//------
	public static ArrayList<ArrayList<Integer>> FindContinuousSequece(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (sum==1) {
			return result;
		}
		//����ָ����
		ArrayList<Integer> temp = new ArrayList<>();
		int tempSum=0;
		//��̿��Ϊ2�������б߽����ﵽsum/2(��Ϊsum/2+sum/2+1)
		int mid=(sum+1)/2;
		for (int i = 1; i < mid; i++) {
			tempSum+=i;
			temp.add(i);
			
			//������ڣ��ͳ���������ߣ�Ȼ��������
			if (tempSum > sum) {
				// ȥ�����е�һ��,ֱ��������
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
