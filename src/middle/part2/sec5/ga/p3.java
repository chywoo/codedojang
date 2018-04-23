package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 삼각형 화단

/**
 * 주요 공식
 * <li> i + j + k = N</li>
 * <li> i + j > k</li>
 * <li> i <= N / 3 and j <= N / 3 and k <= N / 3</li>
 * <li> i >= j >= k로 정의해서 loop. 이 조건에서 i는 최대 N/3까지, j는 최대 N/2까지의 값을 가진다.</li>
 */
public class p3 {

	public static String input = "6 3 9 10 1000 50000 100000";
	static public int T;
	static public int N;
    static public long Answer;

	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			N = sc.nextInt();
			int k;

            Timer.start();
            Answer = solve_basic();

			System.out.printf("#%d Basic: %d => %d, %fs\n", test_case, N, Answer, Timer.end());

            Timer.start();
            Answer = solve_advanced();

            System.out.printf("#%d Advan: %d => %d, %fs\n", test_case, N, Answer, Timer.end());
		}

		sc.close();
	}

    private static long solve_basic() {
        int k;
        long c = 0;

        for ( int i = 1; i <= N; i++)
        {
            for ( int j = i; j <= N; j++)
            {
                k = N - j - i;
				if ( j <= k && i + j > k )
				{
					c++;
				}

            }
        }

        return c;
    }

    private static long solve_advanced() {
	    long answer = 0;
        int k;

        for ( int i = 1; i <= N/3; i++) // i는 아무리 커도 N/3보다 이하이다. i는 가장 작은 수라고 가정했으므로.
        {
            for ( int j = (N/2) - i; j <= (N - i) / 2; j++) // i값을 제외한 N 값에서 그 반보다는 이하여야 한다 크면 j값이 k값보다 작다 정의를 위배
            {
                k = N - j - i;

                if (j >= i && k >= j && k < j + i)
                {
                    answer++;
//					System.out.printf("(%d,%d,%d) ", k, j, i);
                }
            }
        }

        return answer;
    }
}
