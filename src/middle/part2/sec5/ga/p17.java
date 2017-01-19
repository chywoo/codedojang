package middle.part2.sec5.ga;

import util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

// 예산 관리
public class p17 {

    public static String input = "1 " +
            "40 " +
            "6 " +
            "7 13 17 19 29 31";

    static public int T;
    static public int M, N, Answer;
    static public int[] data;
    static public int maxBudget = 0;
    static public boolean budgetMatch = false;

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            M = sc.nextInt();
            N = sc.nextInt();

            data = new int[N];

            for (int i = 0; i < N; i++) {
                data[i] = sc.nextInt();
            }

            Timer.start();

            Answer = solve(0);
            System.out.printf("#%d type 1: %d, %fs\n", test_case, Answer, Timer.end());
        }

        sc.close();
    }

    private static int solve(int budget) {

        if (budget > M) return maxBudget;

        if ( maxBudget < budget )
            maxBudget = budget;

        for (int i = N - 1; i >= 1; i--)
        {
            if ( budgetMatch ) return M;

            if ( budget + data[i] == M ) {
                maxBudget = M;
                budgetMatch = true;

                return M;
            }

            solve(budget + data[i]);
        }

        return maxBudget;
    }
}
