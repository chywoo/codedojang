import java.util.*;

public class Tetris {
	int x1, x2;
	int y;
	final static int N = 10;
	
	public Tetris(int x1, int x2, int y)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y = y;
	}
	
//	static int board[][] = { 
//			{1, 0, 1, 1},
//			{1, 0, 0, 0},
//			{0, 1, 1, 0},
//			{0, 0, 0, 0}
//	};
	
	static int board[][] =  {
			{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 1, 1, 0, 0, 0, 1, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 1, 0, 0, 0, 1, 1, 0, 1 }
	};
	
	public static void main(String[] args)
	{
		ArrayList<Tetris> list = new ArrayList<Tetris>(); 

//		System.out.println("### BOARD ###");
//		printMatrix();
		
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (board[i][j] == 1)
				{
					if (j < N - 1 && board[i][j + 1] == 1)
					{
						list.add(new Tetris(j, j + 1, i));
						board[i][j] = 2;
						board[i][j + 1] = 2;
					}
					else if (i < N - 1 && board[i + 1][j] == 1)
					{
						list.add(new Tetris(j, j, i + 1));
						board[i][j] = 2;
						board[i + 1][j] = 2;
					}
				}
			}
		}

//		for (Tetris obj : list)
//		{
//			System.out.printf(" - %d, %d, %d\n", obj.x1, obj.x2, obj.y);
//		}
		
		list.sort(new Comparator<Tetris>() { 
			public int compare(Tetris a, Tetris b)
			{
				return b.y - a.y;
			}
		});
		
		
//		System.out.println("Count: " + list.size());
//		System.out.println("## start ##");
//		printMatrix();
		
		for (Tetris obj : list) 
		{
			// System.out.printf(" - %d, %d, %d\n", obj.x1, obj.x2, obj.y);
			int new_y;

			if (obj.x1 == obj.x2) 	// 세로 블럭 
			{ 
				for (new_y = obj.y; new_y < N; new_y++) 
				{

					if (new_y + 1 == N || board[new_y + 1][obj.x1] != 0)
						break;
				}

				board[obj.y - 1][obj.x1] = 0;
				board[obj.y][obj.x2] = 0;

				board[new_y - 1][obj.x1] = 2;
				board[new_y][obj.x2] = 2;
			} 
			else 
			{ 				// 가로 블럭
				for (new_y = obj.y; new_y < N; new_y++)
				{
					if (new_y + 1 == N || (board[new_y + 1][obj.x1] != 0 || board[new_y + 1][obj.x2] != 0))
						break;
				}

				board[obj.y][obj.x1] = 0;
				board[obj.y][obj.x2] = 0;

				board[new_y][obj.x1] = 2;
				board[new_y][obj.x2] = 2;
			}

//			System.out.printf("### (%d,%d), (%d,%d) ###\n", obj.x1, obj.y, obj.x2, obj.y);
//			printMatrix();
		}
		
//		System.out.println("### NEW BOARD ###");
//		printMatrix();
		
		printResult();
	}

	private static void printMatrix() {
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
				System.out.printf(" %d ", board[i][j]);
			
			System.out.println();
		}
	}
	
	private static void printResult() {
		int count;
		
		for (int i = 0; i < N; i++)
		{
			count = 0;
			for (int j = N - 1; j >= 0; j--)
				if ( board[j][i] != 0) count = N - j;
			
			System.out.printf("%d ", count);
		}
		
		System.out.println();
	}
}
