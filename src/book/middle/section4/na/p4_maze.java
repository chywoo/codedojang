package book.middle.section4.na;

import util.Timer;
import java.io.*;
import java.util.*;

/**
 * Page: 100
 * Name: 미로 찾기
 */
public class p4_maze {

	public static String input = "1 5 5\n" +
			"#S### " +
			"#...# " +
			"#.#.# " +
			"#.... " +
			"###G#";
	static public int T, Answer;
	static public int H, W;
	static public char data[][];
	static public int dx[] = {1, 0, -1, 0};
	static public int dy[] = {0, 1, 0, -1};
	
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Timer.start();
			
			H = sc.nextInt();
			W = sc.nextInt();
			
			data = new char[H][W];
			int num = 0;
			
			for ( int i = 0; i < H; i ++)
			{
				char s[] = sc.next().toCharArray();
				System.arraycopy(s, 0, data[i], 0, s.length);
			}
exitloop:			
			for ( int i = 0; i < H; i ++)
			{
				for ( int j = 0; j < W; j++ )
					if (data[i][j] == 'S')
					{
						Answer = bfs(i, j);
						break exitloop;
					}
			}
			
			System.out.printf("#%d = %d, %fs\n", test_case, Answer, Timer.end());
		}
		
		sc.close();
	}

	
	private static int bfs(int i, int j) {
		int level = 0;
		int v[] = new int[3];
		int h, w;
		
		Deque<int[]> deq = new ArrayDeque<int[]>();
		v[0] = i;
		v[1] = j;
		v[2] = level;
		
		deq.addFirst(v);
		
		while (!deq.isEmpty()) {
			
			v = deq.removeLast();
			
			h = v[0];
			w = v[1];
			level = v[2] + 1;
			
			for (int k = 0; k < 4; k++) {
				int h2 = h + dx[k]; // 4������ ��� Ž��
				int w2 = w + dy[k];

				if ((h2 >= 0 && h2 < W) && (w2 >= 0 && w2 < H))
				{
					if (data[h2][w2] == 'G')
						return level;
					
					if (data[h2][w2] == '.')
					{
						int child[] = new int[3];
						
						data[h2][w2] = (char)('0' + level);
						
						child[0] = h2;
						child[1] = w2;
						child[2] = level;
						deq.addFirst(child);
					}
				}
			}
		}
		
		return -1;
	}
}
