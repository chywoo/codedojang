package study;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Permuation {
	static int N;
	static boolean used[] = new boolean[27];
	static char solution[] = new char[27];
	static int cntSolution = 0;

	public static void main(String[] args) throws Exception {
		Scanner sc;

		System.setIn(new FileInputStream("permuation.dat"));
		sc = new Scanner(System.in);

		int numOfTest = sc.nextInt();

		for (int test_case = 0; test_case < numOfTest; test_case++) {
			N = sc.nextInt();

			// 새로운 Test case를 위한 데이터 초기
			Arrays.fill(used, false);
			Arrays.fill(solution, (char) 0);
			cntSolution = 0;

			System.out.printf("%d: \n", test_case + 1);
			Permutation(0);
			System.out.println(" Count = " + cntSolution);
		}

		sc.close();

	}

	// n: 순열을 만들고 있는 자리 번호
	private static void Permutation(int n) {
		if (n == N) { // 순열 자리 번호가 N번째라는 것은 주어진 문자열을 모두 사용하였다는 뜻 = 순열 완성
			cntSolution++; // 순열이 완성되었으므로 개수를 하나 증가
			System.out.println(" - " + String.copyValueOf(solution));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (used[i] == true) // 이미 사용된 문자인지 확인
				continue;

			solution[n] = (char) (i + 'A');

			used[i] = true; // 사용하는 문자로 표기하고 다음 문자열 자리로 이동
			Permutation(n + 1);
			used[i] = false; // 뒷쪽 문자의 처리가 완료되었으므로 사용한 문자 표기를 제거
		}

	}
}
