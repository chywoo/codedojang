package book.middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 스마트
public class p11 {

	public static String input = "2\n" + 
	"5 60 " +
	"20 10 20 35 40 " +
	"3 5 3 5 4 " +
	"23 290 " +
	"20 75 82 18 2 39 5 28 9 46 5 3 28 45 12 23 66 23 42 8 2 1 23 " +
	"3 9 10 38 3 7 32 12 11 0 23 44 9 8 34 77 53 32 31 54 33 5 66";

	static public int T;
	static public int N, M, Answer;
	static public int[] data;
	static public int[] cost;
	static public int[] check;
	static public int[] dump;
	static public int[][] buffer;
	static public int min_cost;
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			data = new int[N];
			cost = new int[N];
			check = new int[N];
			dump = new int[N];
			
			min_cost = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++)
			{
				data[i] = sc.nextInt();
			}
			
			for(int i=0; i < N; i++)
			{
				cost[i] = sc.nextInt();
			}
			
			Timer.start();
			
			Answer = solve(0, 0, 0);

			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
			for(int i : dump)
			{
				if (i == 0) continue;
				
				System.out.printf("%d ", i);
			}
			System.out.println();
			
			// Solve2
			buffer = new int[N+1][M+1];
			Timer.start();
			
			Answer = solve2(N, M);

			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
			
		}
		
		sc.close();
	}

	private static int solve(int num, int sum_mem, int sum_cost) {
		if (min_cost <= sum_cost )
			return min_cost;

		if (num == N || sum_mem >= M)
		{
			
			if (min_cost > sum_cost)
			{
				min_cost = sum_cost;
				System.arraycopy(check, 0, dump, 0, check.length);
				
//				System.out.print("[DUMP] ");
//				for(int i : dump)
//				{
//					if (i == 0) continue;
//					
//					System.out.printf("%d ", i);
//				}
//				System.out.println();
			}
		}
		else
		{
			for (int i=num; i<N; i++)
			{
				if (check[i] != 0) continue;
				
				check[i] = i + 1;
				solve(num + 1, sum_mem + data[i], sum_cost + cost[i]);
				check[i] = 0;
			}
		}
		
		return min_cost;
	}
	
	private static int solve2(int i, int r)
	{
		if ( i >= 0 && r >= 0 && buffer[i][r] != 0)
			return buffer[i][r];
		
		if (i == 0)
		{
			if (r > 0)
			{
				buffer[i][r] = 999999; // Overflow회피를 위해 Integer.MAX_VALUE를 쓰면 안 됨.
				return 999999;
			}
			else
				return 0;
		}
		
		if ( r < 0 ) // 확보해야 할 메모리가 없음. 그래서 앱을 종료할 필요가 없으므로 비용응 0
			return 0;
		
		buffer[i][r] = Math.min(solve2(i - 1, r), solve2(i - 1, r - data[i-1]) + cost[i-1]);
		
		return buffer[i][r];
	}
}
