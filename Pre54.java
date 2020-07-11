package SwordMeansOffer;

import java.util.Arrays;

/**
* @author Helexy22
* @version Time��2020��7��1�� ����3:31:46
* @Issue:�ַ����е�һ�����ظ����ַ�
* ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
* ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
* ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
*/
public class Pre54 {

	//------
	static int Max=1<<15;
	int[] visited=new int[Max];
	StringBuilder sb = new StringBuilder();
	
	public void insert(char ch) {
		if (visited[ch]==0) {
			sb.append(ch);
		}
		visited[ch]++;
	}
	
	public char FistAppearingOnce() {
		for (int i = 0; i < sb.length(); i++) {
			if (visited[sb.charAt(i)]==1) {
				return sb.charAt(i);
			}else if (visited[sb.charAt(i)]>1) {
				sb.delete(0,1);
				i-=1;
			}
		}
		return '#';
	}
	
	int[] count=new int[Max];
	int index=0;
	
	{
		Arrays.fill(count,-1);
	}
	
	//----------------
	public void	Insert2(char ch) {
		if (count[ch]==-1) {
			count[ch]=(index++);
		}else if (count[ch]>=0) {
			count[ch]=-2;
		}
	}
	
	public char FirstApperingOnce2() {
		char ch='#';
		int minIndex=Integer.MAX_VALUE;
		for (int i = 0; i < Max; i++) {
			if (count[i]>=0&&count[i]<minIndex) {
				ch=(char)i;
				minIndex=count[i];
			}
		}
		return ch;
	}
}
