package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��7��2�� ����10:40:32
* @Issue:	�����˵��˶���Χ
* ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
* ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37����
* ��Ϊ3+5+3+7 = 18��
* ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
*/
public class Pre66 {

	public int movingCount(int threshold,int rows,int cols) {
		if (threshold<0||rows<=0||cols<=0) {
			return 0;
		}
		boolean[][] visited=new boolean[rows][cols];
		return dfs(threshold,rows,cols,0,0,visited);
	}

	public int dfs(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (row<0||row>=rows||col<0||col>=cols||visited[row][col]||!isVaild(row,col,threshold)) {
			return 0;
		}
		 //����ѷ��ʹ��Ľڵ�
		int count=1;
		visited[row][col]=true;
		count+=dfs(threshold,rows,cols,row+1,col,visited);
		count+=dfs(threshold,rows,cols,row,col+1,visited);
		return count;
	}

	// �жϵ�ǰ�ڵ��Ƿ�����Լ��
	public boolean isVaild(int row, int col, int threshold) {
		// TODO Auto-generated method stub
		int result=countOfEachDigit(row);
		result+=countOfEachDigit(col);
		return result<=threshold;
	}

	//��һ������λ��֮��
	private int countOfEachDigit(int num) {
		// TODO Auto-generated method stub
		int result=0;
		while (num!=0) {
			result+=num%10;
			num/=10;
		}
		return result;
	}
}
