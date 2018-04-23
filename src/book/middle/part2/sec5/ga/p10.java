package book.middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 최소 합 구하기
public class p10 {

	public static String input = "2\n" + 
	"3 " +
	"1 5 3 " +
	"2 4 7 " +
	"5 4 5 " +
	"10 " +
	"1 2 4 7 9 7 1 2 9 0 " +
	"2 1 7 2 5 7 1 1 6 4 " +
	"9 0 1 5 7 1 2 4 5 8 " +
	"2 5 3 1 2 2 1 1 4 8 " +
	"5 4 3 7 1 0 7 2 1 2 " +
	"1 2 4 7 29 1 1 2 9 51 " +
	"2 9 7 2 6 7 1 21 6 4 " +
	"9 1 42 5 2 1 2 1 55 8 " +
	"2 5 28 2 52 2 14 1 1 8 " +
	"5 4 3 7 9 1 71 2 12 100";
	
	static public int T;
	static public int N, Answer;
	static public int[][] data;
	static public int[] check;
	static public int min;
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			
			data = new int[N][N];
			check = new int[N];
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
					data[i][j] = sc.nextInt();
			}
			
			Timer.start();
			
			Answer = solve(0, 0);

			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
			
		}
		
		sc.close();
	}

	private static int solve(int row, int sum) {
		if (min <=sum )
			return min;

		if (row == N)
		{
			min = (min > sum) ? sum : min;
		}
		else
		{
			for (int i=0; i<N; i++)
			{
				if (check[i] != 0) continue;
				
				check[i] = 1;
				solve(row + 1, sum + data[row][i]);
				check[i] = 0;
			}
		}
		
		return min;
	}
}
