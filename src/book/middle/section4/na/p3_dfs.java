package book.middle.section4.na;

import java.io.*;
import java.util.*;

/**
 * Page: 96
 * Name: 두더지 굴(L)
 */
public class p3_dfs {

	public static String input = "1 7\n" +
			"0 1 1 0 1 0 0 " +
			"0 1 1 0 1 0 1 " +
			"1 1 1 0 1 0 1 " +
			"0 0 0 0 1 1 1 " +
			"0 1 0 0 0 0 0 " +
			"0 1 1 1 1 1 0 " +
			"0 1 1 1 0 0 0 ";
	static public int T, Answer;
	static public int N, V;
	static public int data[][];
	static public int size[];
	static public int dx[] = {1, 0, -1, 0};
	static public int dy[] = {0, 1, 0, -1};
	
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			data = new int[N][N];
			size = new int[N];
			int num = 0;
			
			Arrays.fill(size, 0);
			
			for ( int i = 0; i < N; i ++)
				for (int j =0; j < N; j++)
				data[i][j] = sc.nextInt();
			
			for ( int i = 0; i < N; i ++)
				for (int j = 0; j < N; j++)
					if ( data[i][j] == 1 )
					{
						size[num++] = bfs(i, j);
					}
			
			Arrays.sort(size, 0, num);
//			System.out.printf("#%d = %d\n", test_case, Answer);
			for ( int i = 0; i < num; i++ )
			{
				System.out.println(size[i]);
			}
		}
		
		sc.close();
	}

	
	private static int bfs(int i, int j) {
		int node_count = 0;
		int v[] = new int[2];
		int x, y;
		
		Deque<int[]> deq = new ArrayDeque<int[]>();
		data[i][j] = 0;
		v[0] = i;
		v[1] = j;
		
		deq.addFirst(v);
		
		while (!deq.isEmpty()) {
			node_count++;
			
			v = deq.removeLast();
			
			x = v[0];
			y = v[1];
			
			for (int k = 0; k < 4; k++) {
				int x2 = x + dx[k]; // 4������ ��� Ž��
				int y2 = y + dy[k];

				if ((x2 >= 0 && x2 < N) && (y2 >= 0 && y2 < N) && data[x2][y2] == 1)
				{
					int child[] = new int[2];
					
					data[x2][y2] = 0;
					
					child[0]= x2;
					child[1] = y2;
					deq.addFirst(child);
				}
			}
		}
		
		return node_count;
	}
}
