package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 약수의 합
public class p1 {

	public static String input = "1 10";
	static public int T;
	static public long N, Answer;
	
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Timer.start();
			
			N = sc.nextLong();

			for ( int i = 1; i < N / 2; i++)
			{
				if ( N % i == 0 )
					Answer += i + (N/i);
			}

			
			System.out.printf("#%d = %d, %fs\n", test_case, Answer, Timer.end());
		}
		
		sc.close();
	}
}
