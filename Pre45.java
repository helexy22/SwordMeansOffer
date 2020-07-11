package SwordMeansOffer;

import java.util.Arrays;

/**
* @author Helexy22
* @version Time：2020年6月29日 下午2:06:21
* @Issue:扑克牌顺子
* LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
* 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
* “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
* 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
* 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
* LL决定去买体育彩票啦。
*  现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
*  为了方便起见,你可以认为大小王是0。
*/
public class Pre45 {
	

	//深度优先 dfs
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
		
		//如果为0，这里就遍历取值考察
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
			//如果是固定的值，直接跳过
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
			//统计0的个数
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
