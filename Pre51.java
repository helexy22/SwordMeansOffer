package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��7��1�� ����11:15:22
* @Issue:�����˻�����
* ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
* ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
* ��ע�⣺�涨B[0] = A[1] * A[2] * ... * A[n-1]��B[n-1] = A[0] * A[1] * ... * A[n-2];��
*/
public class Pre51 {

	public static int[] multiply(int[] A) {
		int[] left=new int[A.length];
		int[] right=new int[A.length];
		int[] B=new int[A.length];
		
		int result=1;
		for (int i = 0; i < A.length; i++) {
			left[i]=(result*=A[i]);
		}
		result=1;
		for (int i = 0; i < A.length; i++) {
			right[i]=(result*=A[i]);
		}
		for (int i = 0; i < A.length; i++) {
			B[i]=i==0?1:right[i-1];
			B[i]*=i==A.length-1?1:right[i-1];
		}
		return B;
	}
	
	//--------
	public static int[] multiply2(int[] A) {
		int[] B=new int[A.length];
		B[0]=1;
		for (int i = 1; i <A.length; i++) {
			B[i]=B[i-1]*A[i-1];
		}
		int result=1;
		for (int i = A.length-2; i >=0; i--) {
			result*=A[i+1];
			B[i]*=result;
		}
		return B;
	}
	
	public static void main(String[] args) {
		int[] num= {1,2,3,4,5};
		int[]B=multiply2(num);
		for (int i : B) {
			System.out.println(i+" ");
		}
		System.out.println();
	}
}
