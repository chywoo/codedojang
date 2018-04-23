package book.middle.part2.sec5.ga;

import util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

// bicoloring
public class p13 {

    public static String input = "2\n" +
            "3 3 " +
            "0 1 " +
            "1 2 " +
            "2 0 " +
            "9 " +
            "0 1 " +
            "0 2 " +
            "0 3 " +
            "0 4 " +
            "0 5 " +
            "0 6 " +
            "0 7" +
            "0 8";

    static public int T;
    static public int N, E, Answer;
    static public int[][] data;
    static public int nodeColor[];
    static public final int COLOR = 10;

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            E = sc.nextInt();

            data = new int[N][N];
            nodeColor = new int[N];

            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                data[a][b] = data[b][a] = 1;
            }

            Timer.start();

            Answer = solve(0, COLOR);

            System.out.printf("#%d: %s, %fs\n", test_case, Answer == 1 ? "OK" : "IMPOSSIBLE", Timer.end());

        }

        sc.close();
    }

    private static int solve(int n, int color)
    {
        ArrayList<Integer> list = new ArrayList<>();

        if (n == N) return 1;

        for (int i = 0; i < N; i++)
        {
            if ( data[n][i] == 0 ) continue;
            if ( nodeColor[i] == color ) return 0; // 인접한 노드가 동일한 색이면 IMPOSSIBLE
            else {
                nodeColor[i] = ~color; // 색칠이 안 된 노드를 다른 색으로 색칠
                list.add(i); // 색칠이 안 된 노드를 리스트를 만들어 관리
            }
        }

        for (Integer i : list)
        {
            if ( solve(i, ~color) == 0 )
                return 0;
        }

        return 1;
    }
}
