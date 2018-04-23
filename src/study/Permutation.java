package study;

public class Permutation {
	static int N = 4;
	static int used[] = new int[4];  // 사용 여부 기록
	static int sol = 0;

	static public void main(String[] args) {
		perm(0);
		System.out.println("Permutation: " + sol);
	}

	static private void perm(int n) {
		if (n == N) {    // 완료 조건은 한계 길이인 N까지 도달 했을 때이다.
			sol++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (used[i] != 0)   // 사용된 것은 skip한다.
				continue;

			used[i] = 1;

			perm(n + 1);

			used[i] = 0;
		}
	}
}
