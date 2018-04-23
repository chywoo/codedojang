package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 스마트
public class p12 {

	public static String input = "1\n" + 
	"8 9 " +
	"0 0 0 0 0 0 0 0 0 "+
	"0 0 0 1 1 0 0 0 0 "+
	"0 0 0 1 1 0 1 1 0 "+
	"0 0 1 1 1 1 1 1 0 "+
	"0 0 1 1 1 1 1 0 0 "+
	"0 0 1 1 0 1 1 0 0 "+
	"0 0 0 0 0 0 0 0 0 "+
	"0 0 0 0 0 0 0 0 0 ";

	static public int T;
	static public int N, M, Answer;
	static public int[][] data;
	static public ArrayList<Integer> listClosed = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			data = new int[N][M];
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
					data[i][j] = sc.nextInt();
			}
			
			Timer.start();
			
			Answer = solve();

			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
		}
		
		sc.close();
	}

	private static int solve() 
	{
		int count = 0;
		int removed = 0;
		
		do {
			check_closed_box();
			removed = remove_contact();
			remove_closed_box();
			if (removed > 0)
				count++;
		} while (removed > 0);
		
		return count;
	}
	
	private static void remove_closed_box() {
		for(int i: listClosed)
		{
			int r = i / M;
			int c = i % M;
			
			data[r][c] = 0;
		}
		
		listClosed.clear();
	}

	private static int remove_contact() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++)
		{
			for (int j=0; j<N; j++)
			{
				if (data[i][j] ==1 && isContacted(i, j))
				{
					list.add(i * M + j);
				}
			}
		}
		
		// 인접한 치즈 제거
		for (int i : list)
		{
			int r = i / M;
			int c = i % M;
			data[r][c] = 0;
		}
		
		return list.size();
	}

	private static boolean isContacted(int i, int j) {
		int c = 0;
		
		if (data[i][j-1] == 0) c++;
		if (data[i][j+1] == 0) c++;
		if (data[i-1][j] == 0) c++;
		if (data[i+1][j] == 0) c++;
		
		return c > 1;
	}

	private static void check_closed_box()
	{
		for(int i=0; i<N; i++)
		{
			for (int j=0; j<N; j++)
			{
				try{
				if (data[i][j] ==0 && isClosed(i, j))
				{
					data[i][j] = 9;
					listClosed.add(i * M + j);
				}
				}
				catch(Exception e)
				{
					System.out.printf("%d, %d\n", i, j);
					
					throw e;
				}
			}
		}
	}

	private static boolean isClosed(int r, int c) {
		int flag = 0;
		
		if ( r == 0 || r == N - 1 || c == 0 || c == M - 1)
			return false;
		
		for (int i = c; i >= 0; i--)
			if (data[r][i] == 1 || data[r][i] == 9)
			{
				flag |= 0x1;
				break;
			}
		
		for (int i = c; i < M; i++)
			if (data[r][i] == 1 || data[r][i] == 9)
			{
				flag |= 0x2;
				break;
			}
		
		for (int i = r; i >= 0; i--)
			if (data[i][c] == 1 || data[i][c] == 9)
			{
				flag |= 0x4;
				break;
			}
		
		for (int i = r; i < N; i++)
			if (data[i][c] == 1 || data[i][c] == 9)
			{
				flag |= 0x8;
				break;
			}
		
		return flag == 16;
	}
}
