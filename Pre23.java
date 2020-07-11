package SwordMeansOffer;

import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��27�� ����3:46:13
* @Issue:�����������ĺ�����������
* ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
* ����������Yes,�������No���������������������������ֶ�������ͬ��
*/
public class Pre23 {

	public static boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence==null||sequence.length==0) {
			return false;
		}
		return VerifySquenceOfBST(sequence,0,sequence.length-1);
	}
	
	//-------�ݹ��жϵ�ǰ���ṹ�ĺ�������Ƿ������������
	public static boolean VerifySquenceOfBST(int[] sequence,int start,int root) {
		if(start>=root) {
			return true;
		}
		int indexOfRightRoot=start;
		
		//�������ĸ��ڵ�
		while (indexOfRightRoot<root&&sequence[indexOfRightRoot]<=sequence[root]) {
			indexOfRightRoot++;
		}
		//�ж��������Ƿ�ȫ�����ڸ��ڵ�
		for (int i = indexOfRightRoot; i < root; i++) {
			if (sequence[i]<sequence[root]) {
				return false;
			}
		}
		
		 //�ݹ��ж���������
		return VerifySquenceOfBST(sequence,start,indexOfRightRoot-1)&&
				VerifySquenceOfBST(sequence,indexOfRightRoot,root-1);
	}
	
	//------�ǵݹ�ʵ��
	public static boolean VerifySquenceOfBST2(int[] sequence) {
		if (sequence==null||sequence.length==0) {
			return false;
		}
		int index=0;
		int size=sequence.length;
		while (--size>0) {
			//�ҵ���������һ���ڵ�
			while (sequence[index]<sequence[size]) {
				index++;
			}
			//�ж��������Ƿ�����涨
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
