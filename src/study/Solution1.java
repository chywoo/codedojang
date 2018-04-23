package study;

import java.util.Scanner;
import java.io.FileInputStream;


public class Solution1 {
	static String A, B;
	static int N;
	static boolean visited[];
	
	public static void main(String args[]) throws Exception {
		long numA, numB;
		
		System.setIn(new FileInputStream("sample1.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			A = sc.next();
			B = sc.next();
			
			
			numA = getIndex(A);
			numB = getIndex(B);
			
			System.out.printf("%d: %d - %d = %d\n",  test_case, numA, numB, Math.abs(numA - numB) - 1);
		}
	}

	private static long getIndex(String data) {
		long index = 0;
		
		visited = new boolean[N];
		for (int i = 0; i < N; i++)
			visited[i] = false;
		
		for (int i = 0; i < N; i++) {
			int value = getCode(data.charAt(i));
			
			index += value * factorial(N - i - 1);
		}
		
		return index;
	}

	private static long factorial(int num) {
		long value = 1;
		
		if ( num == 0 ) value = 1;
		else {
			for ( int j = 1; j <= num; j++ )
				value *= j;
		}
		
		return value;
	}

	private static int getCode(char charAt) {
		int code = 0;
		int pos = charAt - 'a';
		
		for (int i = 0; i < pos; i++) {
			if (visited[i] == true) continue;
			code++;
		}
		
		visited[pos] = true;
		
		return code;
	}
}
