package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time：2020年6月28日 下午2:01:07
* @Issue:数组中的逆序对
* 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
* 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
* 输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
*/
public class Pre35 {
	
	private static final int MOD=(int)(1e9+7);
	//------
	public static int InversePairs(int[] array) {
		if (array==null||array.length==0) {
			return 0;
		}
		int count=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i]>array[j]) {
					count=(count+1)%MOD;
				}
			}
		}
		return count;
	}
	
	//-----插入排序思想
	public static int InversePairs2(int[] array) {
		if (array==null||array.length==0) {
			return 0;
		}
		int count=0;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j >0&&array[j]<array[j-1]; j--) {
				count=(count+1)%MOD;
				int temp=array[j];
				array[j]=array[j-1];
				array[j-1]=temp;
			}
		}
		return count;
	}
	
	//----
	public static int InverseParis3(int[] array) {
		if (array==null||array.length==0) {
			return 0;
		}
		return merge(array,0,array.length-1);
	}

	public static int merge(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		if (start==end) {
			return 0;
		}
		int mid=start+((end-start)>>1);
		int left=merge(array,start,mid);
		int right=merge(array,mid+1,end);
		int[] aux=new int[end-start+1];
		int index1=start,index2=mid+1,count=0,index=0;
		while (index1<=mid&&index2<=end) {
			if (array[index1]>array[index2]) {
				count=(count+mid-index1+1)%MOD;
				aux[index++]=array[index2++];
			}else {
				aux[index++]=array[index1++];
			}
		}
		while (index1<=mid) {
			aux[index++]=array[index1++];
		}
		while (index2<=end) {
			aux[index++]=array[index2++];
		}
		System.arraycopy(aux,0,array,start,aux.length);
		return (left+right+count)%MOD;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			int[] array=new int[n];
			for (int i = 0; i < n; i++) {
				array[i]=input.nextInt();
			}
			
			System.out.println(InverseParis3(array));
		} 
	}
}
