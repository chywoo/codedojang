package study;

public class fibo {
	static long value[] = new long[100];
	
	public static long fi(int i)
	{
		if (value[i] == 0) {
			if ( i < 2)
				value[i] = 1;
			else
				value[i] = value[i-1] + value[i-2];
		}
		
		return value[i];
	}
	public static void main(String[] args) {
		for (int i = 0; i < 80; i++)
			System.out.printf("%d: %d\n",  i, fi(i));
	}
}
