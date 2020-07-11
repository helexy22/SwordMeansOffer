package SwordMeansOffer;
/**
* @author Helexy22
* @version Time：2020年7月2日 上午10:39:32
* @Issue:矩阵中的路径
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
* 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
* 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 	
   矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
   因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
*/
public class Pre65 {

	public boolean hasPath(char[] matrix,int rows,int cols,char[] str) {
		if (matrix==null||str==null||
				rows*cols<str.length) {
			return false;
		}
		boolean[][] flag= new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(matrix,i,j,rows,cols,0,str,flag)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[] matrix, int row, int col, int rows, int cols, int index, char[] str, boolean[][] flag) {
		// TODO Auto-generated method stub
		if (row<0||row>=rows||col<0||col>=cols||matrix[row*cols+col]!=str[index]||flag[row][col]) {
			return false;
		}
		if (index==str.length-1) {
			return true;
		}
		flag[row][col]=true;
		//上下左右试探，若有一个方向是正确的，那么之后都不递归了
		if (dfs(matrix,row+1,col,rows,cols,index+1,str,flag)||
				dfs(matrix,row-1,col,rows,cols,index+1,str,flag)||
				dfs(matrix,row,col+1,rows,cols,index+1,str,flag)||
				dfs(matrix,row,col-1,rows,cols,index+1,str,flag)) {
			return true;
		}
		flag[row][col]=false;
		return false;
	}
}
