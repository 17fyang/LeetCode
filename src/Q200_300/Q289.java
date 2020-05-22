package Q200_300;
/*
 * 元胞自动机代码
 */
public class Q289 {
	public static void main(String[] args) {
		int board[][]=new int[3][4];
		
		gameOfLife(board);
	}
	public static void gameOfLife(int[][] board) {
		int row=board.length;
		int col=board[0].length;
		int newBoard[][]=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				int result=getNewCondition(board,i,j);
				newBoard[i][j]=result;
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				board[i][j]=newBoard[i][j];
			}
		}
    }
	private static int getNewCondition(int[][] board, int i, int j) {
		int sum=0;
		int row=board.length-1;
		int col=board[0].length-1;
		if(i-1>=0)	sum+=board[i-1][j];
		if(i+1<=row )	sum+=board[i+1][j];
		if(j-1>=0)	sum+=board[i][j-1];
		if(j+1<=col)	sum+=board[i][j+1];
		if(i-1>=0 && j-1>=0)	sum+=board[i-1][j-1];
		if(i+1<=row && j-1>=0)	sum+=board[i+1][j-1];
		if(j+1<=col && i-1>=0)	sum+=board[i-1][j+1];
		if(j+1<=col && i+1<=row )	sum+=board[i+1][j+1];
		
		if(board[i][j]==0 && sum<2 || sum>3)	return 0;
		if(sum==2 && board[i][j]==0)	return 0;
		return 1;
	}
}
