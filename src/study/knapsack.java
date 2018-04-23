package study;

import java.util.ArrayList;
import java.util.Arrays;

public class knapsack {
	static int N = 5;
	static int W = 15;
	static int[] ci = { 2,1,10,2,4};
	static int[] wi = { 2,1,4,1,12};
	static int[][] M = new int[N+1][W+1];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[][] S = new int[N+1][W+1];
	
	public static void main(String args[])
	{
		for(int i=0; i<N+1; i++)
		Arrays.fill(M[i], -1);
		
		System.out.println("Max value: " + ks(N, W));
		for(int i : list)
		{
			System.out.printf("%d, ", i);
		}
		
		System.out.println();
		
		printSolution(N, W);
	}

	private static void printSolution(int i, int w) {
		if (i == 0) {
			return;
		}
		
//		if (S[i][w] == 1) {
//			printSolution( i-1, w - wi[i - 1]);
//			System.out.print(i + " ");
//		}
//		else
//			printSolution(i-1,w);
		
		for (int a = 0; a <= i; a++)
		{
			for (int b =0; b <= w; b++)
			{
				System.out.print(S[a][b] + " ");
			}
			
			System.out.println();
		}
		
	}

	private static int ks(int i, int w) {
		if (i==0)
			return 0;

		if (M[i][w] != -1)
		{
			return M[i][w];
		}
		
		M[i][w] = ks(i-1,w);
		
		if ( w - wi[i-1] > 0)
		{
			int nvalue = ks(i-1, w - wi[i-1]) + ci[i-1];
			
			if (M[i][w] > nvalue)
			{
				list.add(i);
			}
			else
			{
				M[i][w] = nvalue;
				S[i][w] = i;
			}
		}
		
		return M[i][w];
	}

}
