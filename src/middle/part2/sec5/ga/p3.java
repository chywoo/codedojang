package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// upperbound search
public class p3 {

	public static String input = "5 3 9 10 1000 50000";
	static public int T;
	static public int N, Answer;
	
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Answer = 0;
			Timer.start();
			
			N = sc.nextInt();
			int k;
			long c = 0;
			int mj = N;
			int Mj = 0;
			
			for ( int i = 1; i <= N/3; i++)
			{
				for ( int j = (N/2) - i; j <= (N - i) / 2; j++)
				{
					k = N - j - i;
//					if ( j > k )
//						{
//							c++;
//							if ( j < mj ) mj = j;
//							if ( j > Mj ) Mj = j;
//						}
					
					if (j >= i && k >= j && k < j + i)
					{
						Answer++;
//							System.out.printf("(%d,%d,%d) ", k, j, i);
					}
				}
			}
//			System.out.println();
			
			System.out.printf("#%d: %d => %d, %fs\n", test_case, N, Answer, Timer.end());
		}
		
		sc.close();
	}
}
