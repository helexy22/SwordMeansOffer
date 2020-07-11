package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月28日 下午2:59:58
* @Issue:数字在排序数组中出现的次数
* 统计一个数字在排序数组中出现的次数。
*/
public class Pre37 {
	
	public static int GetNumberOfK(int[] array,int k) {
		if (array==null||array.length==0) {
			return 0;
		}
		int count=0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]==k) {
				count++;
			}
		}
		return count;
	}
	
	//------
	public static int GetNumberOfK2(int[] array,int k) {
		if (array==null||array.length==0) {
			return 0;
		}
		int firstOcur=findFirst(array,k);
		int lastOcur=findLast(array,k);
		return lastOcur-firstOcur+1;
	}

	public static int findFirst(int[] array, int k) {
		// TODO Auto-generated method stub
		int start=0,end=array.length-1;
		while (start<=end) {
			int mid=start+((end-start)>>1);
			if (array[mid]<k) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return start;
	}

	public static int findLast(int[] array, int k) {
		// TODO Auto-generated method stub
		int start=0,end=array.length-1;
		while (start<=end) {
			int mid=start+((end-start)>>1);
			if (array[mid]>k) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return end;
	}
	
	//------
	public static int GetNumberOfK3(int[] array,int k ) {
		if (array==null||array.length==0) {
			return 0;
		}
		int index=binarySearch(array,k);
		int count=0;
		if (index!=-1) {
			count++;
			//向前搜索
			for (int i = index-1; i >=0; i--) {
				if (array[i]==k) {
					count++;
				}
			}
			//后向搜索
			for (int i = index+1; i < array.length; i++) {
				if (array[i]==k) {
					count++;
				}
			}
		}
		return count;
	}

	public static int binarySearch(int[] array, int k) {
		// TODO Auto-generated method stub
		int start=0,end=array.length-1;
		while (start<=end) {
			int mid=start+((end-start)>>1);
			if (array[mid]<k) {
				start=mid+1;
			}else if (array[mid]>k) {
				end=mid+1;
			}else {
				end=mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			int[] num=new int[n];
			for (int i = 0; i < n; i++) {
				num[i]=input.nextInt();
			}
			System.out.println(GetNumberOfK3(num,2));
		}
	}
}
