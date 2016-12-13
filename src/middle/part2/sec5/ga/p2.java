package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// �ִ밪
public class p2 {

	public static String input = "1 9 9\n" +
			"3 23 85 34 17 74 25 52 65 " +
			"10 7 39 42 88 52 14 72 63 " +
			"87 42 18 78 53 45 18 84 53 " +
			"34 28 64 85 12 16 75 36 55 " +
			"21 77 45 35 28 75 90 76 1 " +
			"25 87 65 15 28 11 37 28 74 " +
			"65 27 75 41 7 89 78 64 39 " +
			"47 47 70 45 23 65 3 41 44 " +
			"87 13 82 38 31 12 29 29 80";
	static public int T, Answer;
	static public int H, W;
	static public int AnsH, AnsW;
	static public int data[][];
	
	
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
			
			data = new int[H][W];
			Answer = 0;
			int num;
			
			for ( int i = 0; i < H; i ++)
			{
				for ( int j = 0; j < W; j++ )
				{
//					data[i][j] = sc.nextInt();
					num = sc.nextInt();
					
					if ( num > Answer )
					{
						Answer = num;
						AnsH = i;
						AnsW = j;
					}
				}
			}
			
			System.out.printf("#%d = %d (%d,%d) %fs\n", test_case, Answer, AnsH + 1, AnsW + 1, Timer.end());
		}
		
		sc.close();
	}
}
