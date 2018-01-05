package im;

import util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class p20160611 {

    public static String input = "2 " +
            "5 " +
            "2 1 1 2 4 " +
            "1 1 4 2 2 " +
            "2 1 2 3 1 " +
            "3 4 2 3 4 " +
            "1 2 1 1 0 " +
            "4 " +
            "2 1 3 4  " +
            "2 3 3 1 " +
            "1 2 4 1 " +
            "2 1 4 0";

    static public int T;
    static public int N, Answer;
    static public int[][] data;
    static public int direction[][] = {{0,}, {1,0}, {0,1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            data = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    data[i][j] = sc.nextInt();
            }

            Timer.start();

            Answer = solve();
            System.out.printf("#%d %d(%fs)\n", test_case, Answer, Timer.end());
        }

        sc.close();
    }

    private static int solve() {
        int count = 0;
        int x = 0, y = 0;
        int d;

        while(data[y][x] != 0)
        {
            if (data[y][x] == -1) {
                count = 0;
                break;
            }

            d = data[y][x];
            data[y][x] = -1;

//            System.out.printf("(%d,%d)=%d\n", x, y, d);

            x += direction[d][0];
            y += direction[d][1];
            count++;
        }

        return count;
    }
}
