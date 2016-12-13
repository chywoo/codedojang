package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 고기잡이 확장
public class p5 {

	public static String input = "1\n" + 
	"2 6\n" +
	"2 2\n" +
	"1 0 2 0 4 3 " +
	"3 4 0 2 0 3 ";
	static public int T;
	static public int N, M, W, H, Answer;
	static public int data[][];
	
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		Answer = 0;
		int sum;
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Answer = 0;
			sum = 0;
			Timer.start();
			
			N = sc.nextInt();
			M = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			data = new int[N][M];
			
			for ( int i = 0; i < N; i++)
			{
				for ( int j=0; j < M; j++)
				{
					int d = sc.nextInt();
					data[i][j] = d;
				}
			}
				
			for ( int i = 0; i <= N - W; i++)
			{
				for ( int j = 0 ; j <= M - H; j++)
				{
					sum = 0;
					
					for ( int k = 0; k < W; k++)
					{
						for ( int l = 0; l < H; l++)
						{
							sum += data[i + k][j + l];
						}
					}
					
					if ( sum > Answer ) Answer = sum;
				}
			}
//			System.out.println();
			
			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
		}
		
		sc.close();
	}
}
