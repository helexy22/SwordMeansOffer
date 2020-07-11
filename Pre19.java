package SwordMeansOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @author Helexy22
* @version Time��2020��6��26�� ����9:15:23
* @Issue:˳ʱ���ӡ����
* ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
* ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 �����δ�ӡ������
*/
public class Pre19 {
	
	//------ȷ��Ȧ������ӡÿһȦ
	public static ArrayList<Integer> printmatrix(int[][] matrix) {
		if (matrix==null) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<>();
		int row =matrix.length;
		int col=matrix[0].length;
		int countOfCircle=(Math.min(row,col)+1)/2;
		for (int i = 0; i < countOfCircle; i++) {
			int endX=row-i-1;
			int endY=col-i-1;
			//��
			for (int j = i; j <=endY; j++) {
				result.add(matrix[i][j]);
			}
			//��
			for (int j = i+1; j < endX; j++) {
				result.add(matrix[j][endY]);
			}
			//��
			if (endX>i) {
				for (int j = endY-1; j >=i; j--) {
					result.add(matrix[endX][j]);
				}
			}
			//��
			if (endY>i) {
				for (int j = endX-1; j > i; j--) {
					result.add(matrix[j][i]);
				}
			}
		}
		return result;
	}
	
	//------ħ����ת��ӡ
	public static ArrayList<Integer> printmatrix2(int[][] matrix) {
		if (matrix == null) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<>();
		int row = matrix.length;
		while (row!=0) {
			for (int i = 0; i < matrix[0].length; i++) {
				result.add(matrix[0][i]);
			}
			
			//��row == 1ʱ��˵���������һ��Ԫ��
			if (row==1) {
				break;
			}
			matrix=anticlockwiseReverse(matrix);
			row=matrix.length;
		}
		return result;
	}

	//��ʱ����ת����
	private static int[][] anticlockwiseReverse(int[][] matrix) {
		// TODO Auto-generated method stub
		int row =matrix.length;
		int col=matrix[0].length;
		//ɾ���Ѵ�ӡ�ĵ�һ��
		int[][] newMatrix=new int[col][row-1];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row-1; j++) {
				newMatrix[i][j]=matrix[j+1][col-1-i];
			}
		}
		return newMatrix;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n=input.nextInt();
			int m=input.nextInt();
			int[][] matrix=new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j]=input.nextInt();
				}
			}
			List<Integer> result=printmatrix2(matrix);
			for (int item : result) {
				System.out.println(item+' ');
			}
			System.out.println();
		}
	}
}
