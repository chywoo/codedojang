package middle.part2.sec5.ga;

import util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

// 거스름 돈. 문제 8 리모컨과 같은 문제
public class p16 {

    public static String input = "3 " +
            "730 " +
            "5 " +
            "10 50 100 500 1250 " +
            "7300 " +
            "5 " +
            "10 50 100 500 1250 " +
            "15002 " +
            "6 " +
            "1 10 50 100 500 1000";

    static public int T;
    static public int M, N, Answer;
    static public int[] data;
    static public int minCoins;

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            minCoins = Integer.MAX_VALUE;
            M = sc.nextInt();
            N = sc.nextInt();

            data = new int[N];

            for (int i = 0; i < N; i++) {
                data[i] = sc.nextInt();
            }

            Timer.start();

            Answer = solve1(0, 0);
            System.out.printf("#%d type 1: %d, %fs\n", test_case, Answer, Timer.end());

            Timer.start();

            Answer = solve2();
            System.out.printf("#%d type 2: %d, %fs\n", test_case, Answer, Timer.end());
        }

        sc.close();
    }

    private static int solve2() {
        int rest = M;
        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
           count += rest / data[i];
           rest = rest % data[i];

           if (rest == 0 ) return count;
        }

        return count;
    }

    private static int solve1(int n, int depth) {

        if ( minCoins <= depth || n > M) return minCoins;

        if ( n == M )
        {
            minCoins = depth;
        }
        else
        {
            // 큰 금액의 동전으로 먼저 계산해야 최소의 동전 수에 빨리 도착한다.
            // 만약 작은 금액의 동전으로 시작하면 효율이 몇 수십 배 떨어진다
            for (int i = N - 1; i >= 0; i--)
                solve1(n + data[i], depth + 1);
        }

        return minCoins;
    }
}
