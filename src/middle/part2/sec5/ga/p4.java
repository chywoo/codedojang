package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// upperbound search
public class p4 {

	public static String input = "1 6 3\n" + 
	"1 0 2 0 4 3";
	static public int T;
	static public int N, W, Answer;
	static public int data[];
	
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		Answer = 0;
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Answer = 0;
			Timer.start();
			
			N = sc.nextInt();
			W = sc.nextInt();
			data = new int[N];
			
			for ( int i = 0; i < N; i++)
			{
				data[i] = sc.nextInt();
			}
			
			for ( int i = 0; i <= N - W; i++)
			{
				int sum = 0;
				
				for ( int j = 0; j < W; j++)
				{
					sum += data[i + j];
				}
				
				if ( sum > Answer ) Answer = sum;
			}
//			System.out.println();
			
			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
		}
		
		sc.close();
	}
}
