package study;

public class NQueen {
	// 체스보드의 크기
	static int N = 10;
	// 배치방법의 수를 세는 변수
	static int solCnt; // 솔루션 저장배열

	static int[] sol = new int[N];
	// 각 열에서 퀸의 배치여부를 저장하는 배열
	static int[] col = new int[N];

	public static void main(String args[]) {
		solCnt = 0;
		backtrack(0);
		System.out.println(solCnt);
	}

	public static void backtrack(int row) { // 솔루션이라면
		if (isSolution(row)) { // 솔루션을 처리
			processSolution();
			// 메소드를 종료하여 되돌리기 실행
			return;
		}
		// N 개의 열에 대해서 반복
		loop: for (int i = 0; i < N; i++) {
			// 현재 퀸이 배치된 열 가지치기
			if (col[i] == 1) {
				continue loop;
			}

			// 대각선 방향에 퀸이 존재하면 가지치기
			for (int j = 0; j < row; j++) {
				if (Math.abs(row - j) == Math.abs(i - sol[j])) {
					continue loop;
				}
			}

			// 퀸을 배치핚 열 저장
			sol[row] = i;
			// 열에 퀸이 배치되었음을 표시
			col[i] = 1;
			// 다음 행으로 재귀호출
			backtrack(row + 1);
			// 퀸 배치표시 해제
			col[i] = 0;
		}
	}

	// 솔루션 인지를 판단하는 메소드
	public static boolean isSolution(int row) {
		return (row == N);
	}

	// 솔루션 처리 메소드
	public static void processSolution() {
		solCnt++;
	}
}
