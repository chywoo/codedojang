import java.util.ArrayList;
import java.util.Arrays;

public class Juice {

	static long juices[] = new long[50015001];
	static int cntJuice = 0;
	static long customer[] = new long[1000];
	
	static long makeValue(int a, int b, int c)
	{
		long r;
		
		r = (long)a * 10000l * 10000l;
		r += b * 10000l;
		r += c;
		
		return r;
	}
	
	public static void main(String[] args)
	{
		long t1 = System.currentTimeMillis();
		long v;
		
		for(int i = 0; i <= 10000; i++)
		{
			for(int j=0; j <= 10000; j++)
			{
				if ( i + j > 10000)
					continue;
				juices[cntJuice++] = makeValue(i, j, 10000 - i - j );
			}
		}
		Arrays.sort(juices);
		long t2 = System.currentTimeMillis();
		
		
		System.out.println("Time: " + (t2 - t1));
//		System.out.println("Size: " + (long)juices[0] + ", " + (long)juices[cntJuice - 1]);
	}
}
