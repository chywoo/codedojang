package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// upperbound search
public class p8 {

	public static String input = "1\n" + 
	"7 180";
	static public int T;
	static public int N, M, Answer;
	static public int button[] = { 1, 5, 10 };
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();

			Answer = Math.abs(M - N);
			Timer.start();
			Answer = solve_bfs(N);
			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
			
			Answer = Math.abs(M - N);
			Timer.start();
			Answer = solve_dfs(N, 0);
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
		int[] value_obj = new int[2];
		
		ArrayDeque<int[]> deque = new ArrayDeque<int[]>();
		
		if ( Answer <= count )
			return Answer;
		
		if ( start == M )
		{
			return count;
		}

		value_obj[0] = start;
		value_obj[1] = 0;
		
		deque.add(value_obj);
		
		
		while (!deque.isEmpty())
		{
			if (count >= Answer)
				return Answer;
			
			value_obj  = deque.poll();
			temp = value_obj[0];
			count = value_obj[1] + 1;
			
			for (int i=0; i<button.length; i++)
			{
				if (temp < M)
					new_temp = temp + button[i];
				else
					new_temp = temp - button[i];
				
				if ( new_temp == M )
					return count;
				
				else 
				{
					int new_value[] = new int[2];
					new_value[0] = new_temp;
					new_value[1] = count;
					
					deque.add(new_value);
				}
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
