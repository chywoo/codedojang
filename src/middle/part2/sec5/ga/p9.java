package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// 오른편 절단 가능 소수
public class p9 {

	public static String input = "1\n" + 
	"7";
	static public int T;
	static public int N, Answer;
	static public ArrayList<Long> list = new ArrayList<Long>();
//	static public HashSet<Long> primes = new HashSet<Long>();
//	static public long maxPrime;
	
	public static void main(String[] args) {
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
//		primes.add((long)2);
//		primes.add((long)3);
//		primes.add((long)5);
//		primes.add((long)7);
//		primes.add((long)11);
//		primes.add((long)13);
//		maxPrime = 13;
		
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
		if ( n < 2 ) return false;
			
		// 소수가 구해지면 이를 저장했다가, 소수로 나누는 것이 더 효과적.
		for (long i = 2; i * i <= n; i ++)
		{
			if ( n % i == 0 ) return false;
		}
		
		return true;
	}
	
	
	// 망함 ㅠ.ㅠ.. 큰 수가 들어올 경우, 그 수까지 모든 소수를 찾느라 시간 다 까먹음.
//	public static boolean isPrime_enhanced(long n)
//	{
//		if ( n == 2 ) return true;
//		if ( n == 1 || n % 2 == 0 ) return false;
//		
//		// 기존 소수 set에 포함되어 있다면 true.
//		if (primes.contains(n))
//			return true;
//		
//		// 기존 소수 set에 없는데, 소수 set의 최대 소수보다 n이 작으면 소수가 아님
//		if ( n < maxPrime)
//			return false;
//		
//		if ( n > maxPrime) // 누락된 소수를 추가
//		{
//			boolean flag = true;
//			
//			for (long num = maxPrime; num <= n; num += 2)
//			{
//				flag = true;
//				
//				for (long i : primes)
//				{
//					if ( num % i == 0 )
//					{
//						flag = false;
//						break;
//					}
//				}
//				
//				if ( flag )
//				{
//					primes.add(num);
//					maxPrime = num;
//				}
//			}
//		}
//		
//		if (primes.contains(n))
//			return true;
//		
//		return false;
//	}
}
