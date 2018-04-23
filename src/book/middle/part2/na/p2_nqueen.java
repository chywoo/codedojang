package book.middle.part2.na;

import java.util.*;

public class p2_nqueen {

	static int N = 10;
	static int col[];
	static int up[], down[];
	static int answer = 0;
	
	public static void main(String[] args) {
		col = new int[N];
		up = new int[N*2];
		down = new int[N*2];
		
		Arrays.fill(col, 0);
		solve(0);

		System.out.println("Answer: " + answer);
	}

	private static void solve(int row) {
		if (row >= N )
		{
			answer++;
			return;
		}
			
		
		for ( int i = 0; i < N; i++)
		{
			if (col[i] == 1)
				continue;
			
			if ( up[row+i] == 1 ||
					down[N-(row-i)] == 1 )
				continue;
			
			col[i] = 1;
			up[row+i] = 1;
			down[N-(row-i)] = 1;
			
			solve(row + 1);
			
			col[i] = 0;
			up[row+i] = 0;
			down[N-(row-i)] = 0;
		}
	}
	
	public static boolean  isValid(int x, int y)
	{
		return false;
	}

}
