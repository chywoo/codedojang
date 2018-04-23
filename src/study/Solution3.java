package study;

import java.io.FileInputStream;
import java.util.*;

public class Solution3 {
	static int[] ans = new int[200000];
	static long[] arr = new long[200000];
	
	public static void main(String[] args) throws Exception {
		int i, j;
		int T;
		
		System.setIn(new FileInputStream("sample3.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = 0;
			int N = sc.nextInt();
			
			Map<Long, Integer> map = new HashMap<>();
			
			for (i = 0; i < 200000; i++) {
				arr[i] = 0;
			}
			
//			Array.setInt(arr, 0,  0);
			
			for (i = 0; i < N; i++) {
				long x = sc.nextInt(), y = sc.nextInt();
				map.put(x * 1000000001 + y, i + 1);
				arr[i] = x * 1000000001 + y;	
			}
			
			Arrays.sort(arr, 0, N);
			long min = 2000000000;
			
			for (i = 0; i < N; i++) {
				long x = arr[i] / 1000000001;
				long y = arr[i] % 1000000001;
				
				if (min > y) {
					min = y;
					
					ans[cnt] = map.get(arr[i]);
					System.out.printf("%d ==> %d\n", arr[i], ans[cnt]);
					cnt++;
				}
			}
			
			System.out.printf("#%d ", test_case);
			
			for (i=0; i < cnt; i++) {
				System.out.printf("%d ", ans[i]);
			}
			System.out.println("");
		}
	}
}
