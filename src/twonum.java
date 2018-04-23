import java.util.*;

public class twonum {

	public static void main(String[] args)
	{
		int a = 3;
		int b = 4;
		int n = 10;
		TreeSet<Long> setNum = new TreeSet<Long>();
		
		int max = Math.max(a,  b);
		int min = Math.min(a,b);
		
		for (int i = 0; i <= n; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				long v = (long)Math.pow(min,  j) * (long)Math.pow(max, i);
			
				if (v > 1)
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
