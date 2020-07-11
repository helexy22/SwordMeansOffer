package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��6��29�� ����5:00:40
* @Issue:�������ظ�������
* ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
* Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
* ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
*/
public class Pre50 {

	public static boolean dupincate(int numbers[],int length,int[] duplication) {
		boolean[] visited = new boolean[length];
		for (int i = 0; i < length; i++) {
			if (visited[numbers[i]]) {
				duplication[0]=numbers[i];
				return true;
			}else {
				visited[numbers[i]]=true;
			}
		}
		return false;
	}
	
	//-------���ò��ظ��������Ȼ����������Ԫ��ֵ��ȵĽ���
	public static boolean udplication2(int numbers[],int length,int[] duplication) {
		if (numbers==null) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			while (i!=numbers[i]) {
				if (numbers[i]!=numbers[numbers[i]]) {
					int temp=numbers[i];
					numbers[i]=numbers[temp];
					numbers[temp]=temp;
				}else {
					duplication[0]=numbers[i];
					return true;
				}
			}
		}
		return false;
	}
	
	//------����������Ӧ��ָOffer�ı�����Ŀ
	public static boolean dulicate3(int numbers[],int length,int[] duplication) {
		if (numbers==null||numbers.length==0) {
			return false;
		}
		int left=0,right=length-1,mid;
		while (left<=right) {
			mid=left+(right-left>>1);
			int count=countOfRange(numbers,length,left,mid);
			if (count>(mid-left+1)) {
				if (left==right) {
					duplication[0]=left;
					return true;
				}
				right=mid;
			}else {
				left=mid+1;
			}
		}
		return false;
	}

	public static int countOfRange(int[] numbers, int length, int left, int right) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < length; i++) {
			if (numbers[i]>=left&&numbers[i]<=right) {
				count++;
			}
		}
		return count;
	}
	
	//------����Ҫ����ռ䣬ֻ��������
	public static boolean duplicate4(int numbers[],int length,int[] duplication) {
		if (numbers==null||numbers.length==0) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			int index=numbers[i]<0?numbers[i]+length:numbers[i];
			if (numbers[index]<0) {
				duplication[0]=index;
				return true;
			}
			numbers[index]-=length;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] numbers= {1,0,1};
		int[] duplication=new int[1];
		if (duplicate4(numbers,numbers.length,duplication)) {
			System.out.println(duplication[0]);
		}
	}
}
