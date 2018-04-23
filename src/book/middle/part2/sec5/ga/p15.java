package book.middle.part2.sec5.ga;

import util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

// 계산 오르기
public class p15 {

    public static String input = "6 3 4 5 6 7 20";

    static public int T;
    static public int N, Answer;

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            Timer.start();

            Answer = 0;
            solve_tree(0);
            System.out.printf("#%d type 1: %d -> %d, %fs\n", test_case, N, Answer, Timer.end());

            Timer.start();

            Answer = solve2(N);
            System.out.printf("#%d type 2: %d -> %d, %fs\n", test_case, N, Answer, Timer.end());


        }

        sc.close();
    }

    /**
     * N개 계단의 값은 처음 1로 시작할 했을 때 N-1 계단의 값과 처음 2로 시작했을 때 N-2개 계단의 합과 같다.
     * 즉 피보나치 수열이다. F(n) = F(N-1) + F(N-2)
     * 피보나치 수열의 가속화를 위해서는 Memoiation으로 가능하나 여기서는 하지 않는다.
     */
    private static int solve2(int n) {

        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;

        return solve2(n-1) + solve2(n-2);
    }

    /**
     * 트리 기반의 알고리즘
     */
    private static void solve_tree(int n) {
        if (n == N) {
            Answer++;
            return;
        } else if (n > N){
            return;
        }

        solve_tree(n + 1);
        solve_tree(n + 2);
    }

}
