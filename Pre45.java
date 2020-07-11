package SwordMeansOffer;

import java.util.Arrays;

/**
* @author Helexy22
* @version Time��2020��6��29�� ����2:06:21
* @Issue:�˿���˳��
* LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
* ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
* ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,
* ��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
* �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
* LL����ȥ��������Ʊ����
*  ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ� ����������˳�Ӿ����true����������false��
*  Ϊ�˷������,�������Ϊ��С����0��
*/
public class Pre45 {
	

	//������� dfs
	public static boolean isContinuous(int[] numbers) {
		if (numbers==null||numbers.length<5) {
			return false;
		}
		boolean[] visited=new boolean[16];
		for (int i = 0; i < numbers.length; i++) {
			visited[numbers[i]]=true;
		}
		return dfs(numbers,0,visited,0);
		
	}

	public static boolean dfs(int[] numbers, int index, boolean[] visited, int previous) {
		// TODO Auto-generated method stub
		if (index==5) {
			if (isContinuous(numbers)) {
				return true;
			}
			return false;
		}
		
		//���Ϊ0������ͱ���ȡֵ����
		if (numbers[index]==0) {
			for (int i = previous+1; i < 16; i++) {
				if (!visited[i]) {
					numbers[index]=i;
					if (dfs(numbers,index+1,visited,i)) {
						return true;
					}
				}
			}
			return false;
		}else {
			//����ǹ̶���ֵ��ֱ������
			return dfs(numbers,index+1,visited,previous);
		}
	}
	
	public static boolean isContinuousHelper(int[] numbers) {
		int min=findMin(numbers);
		int max=findMax(numbers);
		int actualSum=0;
		for (int i = 0; i < numbers.length; i++) {
			actualSum+=numbers[i];
		}
		int targetSum=(min+max)*2+(max+min)/2;
		return findMax(numbers)-findMin(numbers)==4&&actualSum==targetSum;
	}

	public static int findMin(int[] numbers) {
		// TODO Auto-generated method stub
		int result=16;
		for (int item : numbers) {
			result=Math.min(result,item);
		}
		return result;
	}

	public static int findMax(int[] numbers) {
		// TODO Auto-generated method stub
		int result=0;
		for (int item : numbers) {
			result=Math.max(result,item);
		}
		return result;
	}
	
	//---------------
	public static boolean isContinuous2(int[] numbers) {
		if (numbers==null||numbers.length<5) {
			return false;
		}
		int zeroCount=0;
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length-1; i++) {
			//ͳ��0�ĸ���
			if (numbers[i]==0) {
				zeroCount++;
			}else if (numbers[i]==numbers[i+1]) {
				return false;
			}else {
				zeroCount=(numbers[i+1]-numbers[i]-1);
			}
		}
		return zeroCount>=0;
	}
	
	public static void main(String[] args) {
		int[] numbers= {0,3,2,6,4};
		System.out.println(isContinuous2(numbers));
	}
}
