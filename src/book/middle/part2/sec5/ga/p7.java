package book.middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 최단거리 찾기
public class p7 {

	public static String input = "1\n" + 
	"7 11\n" +
	"1 2 47 " +
	"1 3 69 " +
	"2 4 57 " +
	"2 5 124 " +
	"3 4 37 " +
	"3 5 59 " +
	"3 6 86 " +
	"4 6 27 " +
	"4 7 94 " +
	"5 7 21 " +
	"6 7 40";
	static public int T;
	static public int N, M, Answer;
	static public int data[][];
	static public int visited[];
	static public int value = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		Answer = 0;
		int sum;
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Answer = Integer.MAX_VALUE;
			value = 0;
			sum = 0;
			int x, y;
			Timer.start();
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			data = new int[N + 1][N + 1];
			visited = new int[N + 1];
			
			for ( int i = 0; i < M; i++)
			{
				x = sc.nextInt();
				y = sc.nextInt();
				
				data[x][y] = data[y][x] = sc.nextInt();
			}
				
			Answer = dfs(1);
			
			
			if (Answer == Integer.MAX_VALUE )
				System.out.printf("#%d: %d, %fs\n", test_case, -1, Timer.end());
			else
				System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
		}
		
		sc.close();
	}


	private static int dfs(int node) {
		int v;
		
		visited[node] = 1;
		
		for(int i=1; i <= N; i++)
		{
			v = data[node][i];
			value += v;
			
			if (v != 0 && Answer > value && visited[i] != 1)
			{
				if ( i == N )
				{
					if ( Answer > value )
						Answer = value;
				}
				else
					dfs(i);
			}
			
			value -= v;
		}
		
		visited[node] = 0;
		return Answer;
	}


	private static boolean search_to_rightdown(int r, int c) {
		int i;
		
		if ( r + 4 > N || c + 4 > N )
			return false;
		
		for (i = 0; i < 6 && r + i < N && c + i < N; i++)
			if ( data[r][c] != data[r + i][c + i] )
				break;
		
		return i == 5;
	}


	private static boolean search_to_rightup(int r, int c) {
		int i;
		
		if ( r + 4 > N || c - 4 < 0)
			return false;
		
		for (i = 0; i < 6 && r - i >= 0 && c - i >= 0; i++)
			if ( data[r][c] != data[r - i][c - i] )
				break;
		
		return i == 5;
	}


	private static boolean search_to_right(int r, int c) {
		int i;
		
		if (c + 4 > N) return false;
		
		for (i = 0; i < 6; i++)
			if ( data[r][c] != data[r][c + i] )
				break;
		
		return i == 5;
	}
}
