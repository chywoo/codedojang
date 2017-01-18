package middle.part2.sec5.ga;

import util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

// 거스름 돈. 문제 8 리모컨과 같은 문제
public class p16 {

    public static String input = "2 " +
            "730 " +
            "5 " +
            "10 50 100 500 1250 " +
            "3000 " +
            "5 " +
            "10 50 100 500 1250";

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
        }

        sc.close();
    }

    private static int solve1(int n, int depth) {

        if ( minCoins <= depth || n > M) return minCoins;

        if ( n == M )
        {
            minCoins = depth;
        }
        else
        {
            for (int i = N - 1; i >= 0; i--)
                solve1(n + data[i], depth + 1);
        }

        return minCoins;
    }
}
