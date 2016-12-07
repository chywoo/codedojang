package util;

public class Timer {
	static long start, end;
	
	static public void start()
	{
		start = System.currentTimeMillis();
		end = 0;
	}
	
	static public float end()
	{
		end = System.currentTimeMillis();
		
		return (float)(end - start)/1000;
	}
}
