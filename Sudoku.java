package projects;

public class Sudoku {
	private static int gridSize=9;
	public static void main(String[] args) {
				int[][] board= {{0,0,4,7,1,0,0,0,0},
						        {0,7,2,8,0,6,5,0,0},
						        {0,0,0,0,0,5,0,0,7},
						        {0,1,0,6,9,0,2,0,0},
						        {3,9,0,0,5,0,0,0,0},
						        {0,0,0,0,0,0,0,8,5},
						        {0,0,1,2,3,0,8,0,4},
						        {0,0,3,5,0,4,0,0,2},
						        {2,4,0,9,0,0,0,0,0}};
//						        {1,0,0,0,6,0,0,0,0},
//								{9,8,0,0,0,0,6,0,5},
//								{0,0,0,0,0,5,0,0,1},
//								{0,0,0,0,0,0,3,0,4},
//								{0,6,0,1,3,0,9,0,0},
//								{0,4,0,7,2,0,0,0,0},
//								{0,9,3,0,7,6,1,0,0},
//								{0,0,6,4,8,0,0,0,7},
//								{5,0,0,9,0,2,4,6,0}
//								};
				//printBoard(board);
				if(solver(board)) {
					System.out.println("sudoku is solved");
				} else {
					System.out.println("unsolved mistry");
				}
				
				printBoard(board);
	}
	private static void printBoard(int[][] board) {
		for(int i=0;i<gridSize;i++) {
			
			if(i%3==0 && i!=0) {
				System.out.print("-----------\n");
			}
			for(int j=0;j<gridSize;j++) {
				
				if(j%3==0  && j!=0) {
					System.out.print("|");
				}
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}
	private static boolean rower(int[][] b,int number,int row) {
		for(int i=0;i<gridSize;i++) {
			if(b[row][i]==number) {
				return true;
			}
		}
		return false;
		
	}
	private static boolean cloumner(int[][] b,int number,int col) {
		for(int i=0;i<gridSize;i++) {
			if(b[i][col]==number) {
				return true;
			}
		}
		return false;
		
	}
	private static boolean grider(int[][] b,int number,int row,int col) {
		int rrow=row-row%3;
		 int ccol=col-col%3;
		 for(int i=rrow;i<rrow+3;i++) {
			 for(int j=ccol;j<ccol+3;j++) {
			if(b[i][j]==number) {
				return true;
				}
			 }
		 }
		 return false;
	}
private static boolean isvalid(int[][] b, int number, int row, int col) {
		
		return !rower(b,number,row) && !cloumner(b,number,col) && !grider(b,number,row,col);
	}
	private static boolean solver(int[][] b) {
		 
		 for(int i=0;i<gridSize;i++) {
			 for(int j=0;j<gridSize;j++) {
			if(b[i][j]==0) {
				for(int stry=1;stry<=gridSize;stry++) {
					if(isvalid(b,stry,i,j)) {
						b[i][j]=stry;
						if(solver(b)) {
							return true;
						} else {
							b[i][j]=0;
						}
					}
					
				}
				return false;
				}
			
			 }
		 }
		 return true;
	}
	
	

}
