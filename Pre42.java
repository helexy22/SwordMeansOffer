package SwordMeansOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
* @author Helexy22
* @version Time：2020年6月29日 上午10:11:33
* @Issue:和为S的两个数字
* 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
* 如果有多对数字的和等于S，输出两个数的乘积最小的。
*/
public class Pre42 {

	public int binarySearch(int[] array,int num) {
		int left=0,right=array.length-1;
		while (left<=right) {
			int mid=left+(right-left)/2;
			if (array[mid]>num) {
				right=mid-1;
			}else if (array[mid]<num) {
				left=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	//------二分查找
	public ArrayList<Integer> FindNumberWithSum(int[] array,int sum) {
		 ArrayList<Integer> result = new ArrayList<>();
		 if (array==null||array.length<2) {
			return result;
		}
		 for (int i = 0; i < array.length; i++) {
			int num=sum=array[i];
			if (binarySearch(array,num)!=-1) {
				result.add(array[i]);
				result.add(num);
				return result;
			}
		}
		 return result;
	}
	
	//----左右夹逼
	public ArrayList<Integer> FindNumberWithSum2(int[] array,int sum) {
		ArrayList<Integer> result = new ArrayList<>();
		 if (array==null||array.length<2) {
				return result;
			}
		 int left=0,right=array.length-1;
		 while (left<right) {
			int temp=array[left]+array[right];
			if (temp<sum) {
				left++;
			}else if (temp>sum) {
				right--;
			}else {
				result.add(array[left]);
				result.add(array[right]);
				return result;
			}
		}
		 return result;
	}
	
	//---空间换时间
	public ArrayList<Integer> FindNumberWithSum3(int[] array,int sum) {
		 ArrayList<Integer> result = new ArrayList<>();
		 if (array==null||array.length<2) {
			return result;
		}
		 Set<Integer> set = new HashSet<>();
		 for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		 for (int i = 0; i < array.length-1; i++) {
			int num=sum-array[i];
			if (set.contains(num)) {
				result.add(array[i]);
				result.add(num);
			}
		}
		 return result;
	}
}

