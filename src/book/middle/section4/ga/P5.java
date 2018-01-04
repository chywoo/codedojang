package book.middle.section4.ga;

import java.io.*;
import java.util.Scanner;

/**
 * Page: 62
 * Name: upper bound
 */
public class P5 {

	public static String input = "4\n" +
	"5\n1 3 5 5 7\n5 " +
	"8\n1 2 7 7 7 7 11 15\n7 " +
	"5\n1 2 3 4 5\n7 " +
	"5 2 2 2 2 2 1";
	
	public static void main(String[] args) {
		int T, Answer;
		int N, V;
		int data[];
		int start_p, end_p;
		

		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			data = new int[N];
			
			for ( int i = 0; i < N; i ++)
				data[i] = sc.nextInt();
			
			V = sc.nextInt();
			
			start_p = 0;
			end_p = data.length;
			
			while (end_p > start_p)
			{
				int mid = (start_p + end_p)/2;
				if ( V >= data[mid] )
					start_p = mid + 1;
				else
				{
					end_p = mid;
				}
			}
			
			Answer = end_p + 1;
			
			System.out.printf("#%d = %d\n", test_case, Answer);
		}
	}
}
