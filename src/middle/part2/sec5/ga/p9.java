package middle.part2.sec5.ga;

import util.Timer;
import java.io.*;
import java.util.*;

// ������ ���� ���� �Ҽ�
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
			
		// �Ҽ��� �������� �̸� �����ߴٰ�, �Ҽ��� ������ ���� �� ȿ����.
		for (long i = 2; i * i <= n; i ++)
		{
			if ( n % i == 0 ) return false;
		}
		
		return true;
	}
	
	
	// ���� ��.��.. ū ���� ���� ���, �� ������ ��� �Ҽ��� ã���� �ð� �� �����.
//	public static boolean isPrime_enhanced(long n)
//	{
//		if ( n == 2 ) return true;
//		if ( n == 1 || n % 2 == 0 ) return false;
//		
//		// ���� �Ҽ� set�� ���ԵǾ� �ִٸ� true.
//		if (primes.contains(n))
//			return true;
//		
//		// ���� �Ҽ� set�� ���µ�, �Ҽ� set�� �ִ� �Ҽ����� n�� ������ �Ҽ��� �ƴ�
//		if ( n < maxPrime)
//			return false;
//		
//		if ( n > maxPrime) // ������ �Ҽ��� �߰�
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
