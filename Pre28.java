package SwordMeansOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��27�� ����10:49:58
* @Issue:�����г��ִ�������һ�������
* ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
* ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
*/
public class Pre28 {
	
	
	//-------
	public static int MoreThanHalfNum_Solution(int[] array) {
		if(array==null) {
			return 0;
		}
		Arrays.sort(array);
		int result=array[array.length>>1];
		if (checkVaild(array,result)) {
			return result;
		}
		return 0;
	}

	private static boolean checkVaild(int[] array, int value) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]==value) {
				count++;
			}
		}
		return count>(array.length>>1);
	}
	
	//------��ϣ��˼�룬�����ֵ��Ϊ����������Ϊֵ
	public static int MoreThanHalfNum_Solution2(int[] array) {
		if(array==null) {
			return 0;
		}
		Map<Integer,Integer> count = new HashMap<>();
		int targetCount=array.length>>1;
		for (int i = 0; i < array.length; i++) {
			count.put(array[i],(count.get(array[i])==null?0:count.get(array[i]))+1);
			if (count.get(array[i])>targetCount) {
				return array[i];
			}
		}
		return 0;
	}
	
	//------���������˼�룬����partion, ��������
	public static int MoreThanHalfNum_Solution3(int[] array) {
		if(array==null) {
			return 0;
		}
		int targetIndex=array.length>>1;
		findKthValue(array,0,array.length-1,targetIndex);
		if (checkVaild(array,array[targetIndex])) {
			return array[targetIndex];
		}
		return 0;
	}

	private static void findKthValue(int[] array, int low, int high, int k) {
		// TODO Auto-generated method stub
		if (low<high) {
			int randomPivot=new Random().nextInt(high-low+1)+low;
			swap(array,randomPivot,high);
			int index=low;
			for (int i = low; i <high; i++) {
				if (array[i]<array[high]) {
					swap(array,index,i);
					index++;
				}
			}
			swap(array,index,high);
			if (index>k) {
				findKthValue(array,low,index-1,k);
			}else if (index<k) {
				findKthValue(array,index+1,high,k);
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		if (i!=j) {
			int temp=array[i];
			array[i]=array[j];
			array[j]=temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			int[] nums=new int[n];
			for (int i = 0; i < n; i++) {
				nums[i]=input.nextInt();
			}
			int index=MoreThanHalfNum_Solution3(nums);
			//ע�����
			System.out.println(String.format("index:%d,value:%d",index,nums[index]));
		}
	}
}
