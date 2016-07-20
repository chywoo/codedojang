package study;

public class countintriange {
	static int a[] = { 3, 2, -1};
	static int b[] = { -2, 3, 4 };
	static int c[] = { 0, -11, 0 };
	
	public static long eq(int f, int x, int y){
		return a[f] * x + b[f] * y + c[f];
	}
	
	public static void main(String[] args)
	{
		long c = 0;
		for (int x = -20000; x <= 20000; x++) {
			for ( int y = -20000; y <= 20000; y++) {
//			System.out.printf("(%d,%d): %d, %d, %d\n", x, y, 
//					eq(0, x, y), eq(1, x, y), eq(2, x, y));
				c++;
			}
		}
		
		System.out.println("Count: " + c);
	}
}
