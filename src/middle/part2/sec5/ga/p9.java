package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 오른편 절단 가능 소수
public class p9 {

	public static String input = "1\n" + 
	"3";
	static public int T;
	static public int N, Answer;
	static public ArrayList<Long> list = new ArrayList<Long>();
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			
			Timer.start();
			
			make_prime(0, 1);
			Answer = list.size();
			

			System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
			Long data[] = (Long [])list.toArray(new Long[list.size()]);
			
			Arrays.sort(data);
			for ( long i : data)
			{
				System.out.println(i);
			}
			
		}
		
		sc.close();
	}
	
	
	private static void make_prime(long n, int depth) {
		long value = n;
		
		if ( depth > N )
			return;
		
		for(int i = 1; i <= 9; i++)
		{
			value = n + i;
			if (isPrime(value))
			{
				if (depth == N)
					list.add(value);
				else
					make_prime( value * 10, depth + 1);
			}
		}
	}


	public static boolean isPrime(long n)
	{
		if ( n == 1 ) return false;
		if ( n == 2 ) return true;
		if ( n % 2 == 0) return false;
		
		// 소수가 구해지면 이를 저장했다가, 소수로 나누는 것이 더 효과적.
		for (long i = 3; i < n / 2; i += 2)
		{
			if ( n % i == 0 ) return false;
		}
		
		return true;
	}
}
