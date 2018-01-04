package book.middle.section5.ga;

import util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

// maximum sum
public class p14 {

    public static String input = "1\n" +
            "6 " +
            "6 -7 3 -1 5 2";

    static public int T;
    static public int N, Answer;
    static public int[] data;
    static public int buffer[][];

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            Answer = 0;
            N = sc.nextInt();

            data = new int[N];
            buffer = new int[N + 1][N + 1];

            for (int i = 0; i < N; i++) {
                data[i] = sc.nextInt();
            }

            Timer.start();

            Answer = solve(0, N);
            System.out.printf("#%d type 1: %d, %fs\n", test_case, Answer, Timer.end());

            Timer.start();

            Answer = solve2(0, N);
            System.out.printf("#%d type 2: %d, %fs\n", test_case, Answer, Timer.end());


        }

        sc.close();
    }

    private static int solve(int a, int n) {
        int max = 0, sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum = 0;

                for (int k = i; k <= j; k++)
                    sum += data[k];

                max = Math.max(max, sum);
            }
        }

        return max;
    }


    private static int solve2(int a, int c) {
        for (int i = 0; i < N - 1; i++) {
            Answer = Math.max(Answer, solve(i, N - i));
        }

        return Answer;
    }

    private static int knapsack(int a, int c) {
        int max = 0;

        if (N == 1) return data[0];

        if (buffer[a][c] != 0)
            return buffer[a][c];

        if (a == N - 1 || c == 1) {
            if (data[a] > 0) {
                buffer[a][c] = data[a];

            } else buffer[a][c] = 0;

            return buffer[a][c];
        }

        if (c == 0) return 0;

        for (int i = 0; i < c; i++) {
            max = Math.max(max, solve(a + 1, i) + data[a]);
        }

        buffer[a][c] = max;
        return buffer[a][c];
    }
}
