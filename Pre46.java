package SwordMeansOffer;

import java.util.LinkedList;
import java.util.List;

/**
* @author Helexy22
* @version Time��2020��6��29�� ����2:46:11
* @Issue:�����ǵ���Ϸ(ԲȦ�����ʣ�µ���)
* ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
* ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
* ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,
* ���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
* ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
*/
public class Pre46 {

	//-----
	public static int LastRemaining_Solution(int n,int m) {
		if (n==0||m<=0) {
			return -1;
		}
		boolean[] visited = new boolean[n];
		int count=-1;
		int index=-1;
		int sum=0;
		while (true) {
			index=index+1==n?0:index+1;
			if (!visited[index]) {
				count++;
			}
			if (count==m-1) {
				visited[index]=true;
				if ((++sum)==n) {
					return index;
				}
				count=-1;
			}
		}
	}
	
	//------�������߿⣬������
	public static int LastRemainIng_Solution2(int n,int m) {
		if (n==0||m<=0) {
			return -1;
		}
		List<Integer> student = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			student.add(i);
		}
		int index=0;
		while (student.size()>1) {
			index=(index+m-1)%student.size();
			student.remove(index);
		}
		return student.get(0);
	}
	
	
	//-----Լɪ������
	public static int LastRemaining_Solution3(int n,int m) {
		if (n==0||m<=0) {
			return -1;
		}
		int last=0;
		for (int i = 2; i <=n; i++) {
			last=(last+m)%i;
		}
		return last;
	}
	
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(40000,944));
	}
	
}
