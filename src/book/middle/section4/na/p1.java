package book.middle.section4.na;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Page: 77
 * Name: 두더지 굴(S)
 */
public class p1 {

	public static String input = "1 7\n" +
			"0 1 1 0 1 0 0 " +
			"0 1 1 0 1 0 1 " +
			"1 1 1 0 1 0 1 " +
			"0 0 0 0 1 1 1 " +
			"0 1 0 0 0 0 0 " +
			"0 1 1 1 1 1 0 " +
			"0 1 1 1 0 0 0 ";
	static public int T, Answer;
	static public int N, V;
	static public int data[][];
	static public int visited[][];
	static public int size[];
	static public int level;
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			data = new int[N][N];
			visited = new int[N][N];
			size = new int[N];
			int num = 0;
			
			Arrays.fill(size, 0);
			
			for ( int i = 0; i < N; i ++)
				for (int j =0; j < N; j++)
				data[i][j] = sc.nextInt();
			
			for ( int i = 0; i < N; i ++)
				for (int j = 0; j < N; j++)
					if ( data[i][j] == 1 )
					{
						level = 0;
						size[num++] = dfs(i, j);
					}
			
			Arrays.sort(size, 0, num);
//			System.out.printf("#%d = %d\n", test_case, Answer);
			for ( int i = 0; i < num; i++ )
			{
				System.out.println(size[i]);
			}
		}
	}


	private static int dfs(int i, int j) {
		int node_count = 0;
		
		if ( visited[i][j] == 1 )
			return 0;
		
		visited[i][j] = 1;
		data[i][j] = 0;
		node_count++;
		
		if ( j < N - 1 && data[i][j+1] == 1 )
			node_count += dfs(i, j + 1);
		
		if ( j > 0 && data[i][j-1] == 1 )
			node_count += dfs(i, j-1);
		
		if ( i > 0 && data[i-1][j] == 1 )
			node_count += dfs(i-1, j);
		
		if ( i < N - 1 && data[i+1][j] == 1 )
			node_count += dfs(i+1, j);
		
		
		return node_count;
		
	}
}
