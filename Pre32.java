package SwordMeansOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
* @author Helexy22
* @version Time：2020年6月28日 上午10:25:51
* @Issue:把数组排成最小的数
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
* 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/
public class Pre32 {
	
	//-----实现所有的排列，然后在排列中比较大小(直接 sort,不用遍历)，选择出最小值
	public static String PrintMinNumber(int[] numbers) {
		if (numbers==null||numbers.length==0) {
			return "";
		}
		List<String> result = new ArrayList<>();
		getAllCombine(0,numbers,result);
		Collections.sort(result);//List排序
		return result.get(0);
	}

	public static void getAllCombine(int index, int[] numbers, List<String> result) {
		// TODO Auto-generated method stub
		if (index==numbers.length-1) {
			StringBuilder sb = new StringBuilder();
			for (int num : numbers) {
				sb.append(num);
			}
			result.add(sb.toString());
			return;
		}
		Set<Integer> ocur = new HashSet<>();
		for (int i = index; i < numbers.length; i++) {
			if (!(i!=index&&ocur.contains(numbers[i]))) {
				ocur.add(numbers[i]);
				swap(numbers,i,index);
				getAllCombine(index+1,numbers,result);
				swap(numbers,i,index);
			}
		}
	}

	public static void swap(int[] numbers, int i, int index) {
		// TODO Auto-generated method stub
		int temp=numbers[i];
		numbers[index]=numbers[i];
		numbers[i]=temp;
	}
	
	//----------
	public static String PrintMinNumber2(int[] numbers) {
		if (numbers==null||numbers.length==0) {
			return "";
		}
		//
		String[] strNumbers = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strNumbers[i]=String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strNumbers,new Comparator<String>() {
			public int compare(String o1,String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
		});
		//
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strNumbers.length; i++) {
			sb.append(strNumbers[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			int[] num=new int[n];
			for (int i = 0; i < n; i++) {
				num[i]=input.nextInt();
			}
			System.out.println(PrintMinNumber2(num));
		}
	}
}
