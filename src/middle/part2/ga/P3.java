package middle.part2.ga;

// binary search
public class P3 {

	public static void main(String[] args) {
		int data[] = {1, 2, 3, 5, 7,9,11,15};
		int value = 3;
		int start_p, end_p;
		int result = -1;
		
		start_p = 0;
		end_p = data.length;
		
		while (end_p > start_p)
		{
			int mid = (start_p + end_p)/2;
			if ( data[mid] > value)
				end_p = mid - 1;
			else if ( data[mid] < value )
				start_p = mid + 1;
			else
			{
				result = mid;
				break;
			}
		}
		
		if (result != -1)
			System.out.printf("P is %d, value is %d\n", result, data[result]);
		else
			System.out.println("Not found");
	}
}
