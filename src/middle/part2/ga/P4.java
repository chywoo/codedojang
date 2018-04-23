package middle.part2.ga;

// lowbound search
public class P4 {

	public static void main(String[] args) {
		int data[] = {2, 2, 2, 3, 5, 7,9,11,15};
		int value = 1;
		int start_p, end_p;
		int result = -1;
		
		start_p = 0;
		end_p = data.length;
		
		while (end_p > start_p)
		{
			int mid = (start_p + end_p)/2;
			if ( value > data[mid] )
				start_p = mid + 1;
			else
			{
				end_p = mid;
			}
		}
		
		System.out.printf("%d, %d\n", start_p, end_p);
	}
}
