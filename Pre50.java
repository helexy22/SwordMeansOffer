package SwordMeansOffer;
/**
* @author Helexy22
* @version Time：2020年6月29日 下午5:00:40
* @Issue:数组中重复的数字
* 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
* 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
* 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
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
	
	//-------利用不重复的数组必然数组索引与元素值相等的结论
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
	
	//------方法三，对应剑指Offer的变形题目
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
	
	//------不需要额外空间，只需自身即可
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
