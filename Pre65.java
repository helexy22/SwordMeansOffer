package SwordMeansOffer;
/**
* @author Helexy22
* @version Time��2020��7��2�� ����10:39:32
* @Issue:�����е�·��
* �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
* ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
* ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� 	
   �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
   ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
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
		//����������̽������һ����������ȷ�ģ���ô֮�󶼲��ݹ���
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
