package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// ¿À¸ñ
public class p6 {

	public static String input = "1\n" + 
	"10\n" +
	"0 1 1 0 0 1 1 1 2 0 " +
	"0 0 2 1 0 0 0 0 2 0 " +
	"0 0 0 2 1 0 0 0 0 0 " +
	"0 0 0 0 2 1 1 0 0 0 " +
	"0 0 2 2 0 2 0 0 0 0 " +
	"0 0 0 0 0 0 0 1 2 0 " +
	"0 0 0 0 0 0 0 0 0 0 " +
	"0 0 0 0 0 0 0 0 0 0 " +
	"0 0 0 0 0 0 0 0 0 0 " +
	"0 0 0 0 0 0 0 0 0 0 ";
	static public int T;
	static public int N, Answer, x, y;
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
			
			data = new int[N][N];
			
			for ( int i = 0; i < N; i++)
			{
				for ( int j=0; j < N; j++)
				{
					int d = sc.nextInt();
					data[i][j] = d;
				}
			}
				
			exit:
			for ( int i = 0; i < N; i++)
			{
				for ( int j = 0 ; j < N; j++)
				{
					if (data[j][i] == 0)
						continue;
					
					if ( search_to_right(j, i) == true 
							|| search_to_rightup(j, i) == true 
							|| search_to_rightdown(j,i) == true) 
					{
						Answer = data[j][i];
						x = j;
						y = i;
						
						break exit;
					}
				}
			}
//			System.out.println();
			
			if (Answer == 0 )
				System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
			else
				System.out.printf("#%d: %d (%d,%d), %fs\n", test_case, Answer, x, y, Timer.end());
		}
		
		sc.close();
	}


	private static boolean search_to_rightdown(int r, int c) {
		int i;
		
		if ( r + 4 > N || c + 4 > N )
			return false;
		
		for (i = 0; i < 6 && r + i < N && c + i < N; i++)
			if ( data[r][c] != data[r + i][c + i] )
				break;
		
		return ( i == 5 ) ? true : false;
	}


	private static boolean search_to_rightup(int r, int c) {
		int i;
		
		if ( r + 4 > N || c - 4 < 0)
			return false;
		
		for (i = 0; i < 6 && r - i >= 0 && c - i >= 0; i++)
			if ( data[r][c] != data[r - i][c - i] )
				break;
		
		return ( i == 5 ) ? true : false;
	}


	private static boolean search_to_right(int r, int c) {
		int i;
		
		if (c + 4 > N) return false;
		
		for (i = 0; i < 6; i++)
			if ( data[r][c] != data[r][c + i] )
				break;
		
		return ( i == 5 ) ? true : false;
	}
}
