import java.util.*;

public class twonum {

	public static void main(String[] args)
	{
		int a = 5;
		int b = 3;
		int n = 10;
		TreeSet<Long> setNum = new TreeSet<Long>();
		
		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				long v = (long)Math.pow(a,  j) * (long)Math.pow(b, i);
			
				setNum.add(v);
			}
		}
		
		Iterator<Long> i = setNum.iterator();
		System.out.println("Value is " + setNum.toArray()[9]);
		while (i.hasNext())
		{
			long v = i.next();
			System.out.println(v + ", ");
		}
		
		
	}
}
