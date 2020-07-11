package SwordMeansOffer;
/**
* @author Helexy22
* @version Time：2020年7月2日 上午10:40:32
* @Issue:	机器人的运动范围
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
* 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
* 因为3+5+3+7 = 18。
* 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
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
		 //标记已访问过的节点
		int count=1;
		visited[row][col]=true;
		count+=dfs(threshold,rows,cols,row+1,col,visited);
		count+=dfs(threshold,rows,cols,row,col+1,visited);
		return count;
	}

	// 判断当前节点是否满足约束
	public boolean isVaild(int row, int col, int threshold) {
		// TODO Auto-generated method stub
		int result=countOfEachDigit(row);
		result+=countOfEachDigit(col);
		return result<=threshold;
	}

	//求一个数各位的之和
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
