package SwordMeansOffer;

import java.util.LinkedList;
import java.util.List;

/**
* @author Helexy22
* @version Time：2020年6月29日 下午2:46:11
* @Issue:孩子们的游戏(圆圈中最后剩下的数)
* 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
* 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
* 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
* 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
* 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
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
	
	//------借助工具库，链表集合
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
	
	
	//-----约瑟夫环问题
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
