package study;

import java.util.Arrays;

public class MyNQeen {
	static int N = 10;
	static int col[] = new int[N];
	static int row[] = new int[N];
	static int sol = 0;
	
	
	static public void main(String[] args)
	{	
		Arrays.fill(col, -1);
		Arrays.fill(row, -1);
		
		backtrace(0);
		
		System.out.println("Result: " + sol);
	}
	
	static void backtrace(int row_pos)
	{
		if (row_pos == N)
		{
//			System.out.println("Done");
			sol++;
			return;
		}
		
		for (int col_post = 0; col_post < N; col_post++)
		{
			boolean r = check_mate(row_pos,col_post);
			
//			System.out.printf("(%d, %d) = %b\n", row_pos, col_post, r);
			if (r == false)
			{
				row[row_pos] = col_post;
				col[col_post] = row_pos;
				
				backtrace(row_pos + 1);
				
				row[row_pos] = -1;
				col[col_post] = -1;
			}
		}
	}

	private static boolean check_mate(int row_pos, int col_pos) {
		/*
		 * row_pos는 고정이고, col_pos가 loop를 돈다. 즉, row는 충돌이 발생하지 않는다
		 * 왜냐하면 충돌나지 않는 row를 위하여 col을 찾고 있기 때문이다.
		 * 그러므로 row방향의 충돌은 검사하지 않고, col방향의 충돌만 검사한다.
		 * 해당 컬럼의 col값이 -1이면 이 컬럼에 아직 row가 할당되지 않았음을 나타낸다.
		 * 그래서 col[col_post] != -1이면 row가 존재한다는 의미이다.
		 */
		if (col[col_pos] != -1) // . 
			return true;
		
		for (int i = 0; i < row_pos; i++)//row 기반으로 순환하므로, 현재의 row보다 큰 loop는 무의
		{
			/*
			 * 대각선 방향에 queen이 있다는 것은 두 queen 간의 상하 길이와 좌우 길이가 동일하다는 것으로 판별한다.
			 * 그래서 row_pos - i는 row의 길이이며, col_pos - row[i]는 column의 길이이다.
			 * 이 두 값의 절대값이 동일하면 check이다.
			 */
			if (Math.abs(row_pos - i) == Math.abs(col_pos - row[i]))
				return true;
		}
		return false;
	}
}
