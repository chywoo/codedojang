package book.high;

public class part1 {

	boolean flag;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		part1 problem = new part1();
		
		problem.problem1();
		problem.problem2();
	}
	
	public void problem1()
	{
		int data = 123010980;
		
		flag = true; // first digit
		p1_solve1(data);
		System.out.println();
		
		System.out.println(p1_solve2(data));
		System.out.println(p1_solve3(data));
	}

	private void p1_solve1(int i) 
	{
		if (flag == false || i % 10 != 0)
		{
			System.out.print(i % 10);
			flag = false;
		}
		
		if ( i < 10 ) return;
		p1_solve1(i / 10);
	}
	
	private int p1_solve2(int i)
	{
		if (i < 10)
			return i;
		int p = (int)Math.log10(i);
		return p1_solve2(i/10) + (i % 10) * (int)Math.pow(10, p);
	}
	
	private int p1_solve3(int i)
	{
		if ( i < 10 ) return i;
		
		int a = i % 10;
		int p = (int)Math.pow(10, (int)Math.log10(i));
		
		return a * p + p1_solve3(i % p / 10) * 10 + (int)i/p;
	}
	
	public void problem2()
	{
		int data = 4;
		
		p2_s1(data);
		p2_s2(data);
	}

	private void p2_s1(int n) {
		if (n > 0 )
		{
			p2_s1(n - 1);
			for (int i=0; i <n;i++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private String p2_s2(int n) {
		if (n == 1 )
		{
			System.out.println("*");
			return "*";
		}
		else
		{
			String r = "*" + p2_s2(n - 1);
			System.out.println(r);
			
			return r;
		}
	}
}
