package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// upperbound search
public class p8 {

	public static String input = "1\n" + 
	"0 39";
	static public int T;
	static public int N, M, Answer;
	static public int button[] = { 1, 5, 10 };
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		int sum;
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sum = 0;
			Timer.start();
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			Answer = Math.abs(M - N);
			Answer = solve_bfs(N);
			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
			
//			Answer = solve_direct(N, M);
//			System.out.printf("#%d: %d (%d, %d), %fs\n", test_case, Answer, N, M, Timer.end());
		}
		
		sc.close();
	}


	private static int solve_dfs(int temp, int count) {
		
		if ( Answer <= count )
			return Answer;
		
		if ( temp == M )
		{
			if (Answer > count)
				Answer = count;
			
			return Answer;
		}
			
		
		for (int i=0; i<button.length; i++)
		{
			if ( temp < M)
				solve_dfs(temp + button[i], count + 1);
			else
				solve_dfs(temp - button[i], count + 1);
		}
		
		return Answer;
	}
	
private static int solve_bfs(int start) {
		int count = 0;
		int temp, new_temp;
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		if ( Answer <= count )
			return Answer;
		
		if ( start == M )
		{
			return count;
		}

		deque.add(start);
		
		
		while (!deque.isEmpty())
		{
			count++;
			
			temp  = deque.poll();
			for (int i=0; i<button.length; i++)
			{
				if (temp < M)
					new_temp = temp + button[i];
				else
					new_temp = temp - button[i];
				
				if ( new_temp == M )
					return count;
				
				else deque.add(new_temp);
			}
		}
		
		return count;
	}


	private static int solve_direct(int start, int target) {
		int count = 0;
		int temp = start;
		
		for ( int i = 0; i < button.length; i++ )
		{
			while ( Math.abs(target - temp) > button[i] )
			{
				if ( temp < target )
					temp += button[i];
				else
					temp -= button[i];
				
				count++;
			}
			
			if ( temp == target )
				return count;
			
			if (temp > target )
			{
				int diff = temp - target;
				int diff2 = Math.abs(target - (temp - button[i]));
				
				if ( diff2 < diff )
				{
					temp -= button[i];
					count++;
				}
			}
			else
			{
				int diff = target - temp;
				int diff2 = Math.abs(target - (temp + button[i]));
				
				if ( diff2 < diff )
				{
					temp += button[i];
					count++;
				}
			}
		}
		return count;
	}
}
