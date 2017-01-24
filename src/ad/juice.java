package ad;

import util.Timer;

import java.io.FileInputStream;
import java.util.Scanner;

// 쥬스 문제
public class juice {
    final static public int UNIT = 10000;
    static public int T;
    static public int N, Answer;
    static public int[][] data;
    static public int maxCount;

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("data/juice.dat");
        System.setIn(fis);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            data = new int[N][3];
            maxCount = 0;

            for (int i = 0; i < N; i++) {
                data[i][0] = sc.nextInt();
                data[i][1] = sc.nextInt();
                data[i][2] = sc.nextInt();
            }

            Timer.start();
            Answer = solve();
            System.out.printf("#%d: %d, %fs\n", test_case, Answer, Timer.end());
        }

        sc.close();
        fis.close();
    }

    private static int solve() {
        int x, y, z;
        int count;
        int loop = 0;
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        minX = Math.min(data[0][0], minX);
        maxX = Math.max(data[0][0], maxX);
        minY = Math.min(data[0][0], minY);
        maxY = Math.max(data[0][0], maxY);

        for ( int i = 1; i < N; i++ )
        {
            minX = Math.min(data[i][0], minX);
            maxX = Math.max(data[i][0], maxX);
            minY = Math.min(data[i][0], minY);
            maxY = Math.max(data[i][0], maxY);
        }

        for (x = minX; x <= maxX; x++) {
            int yloop = Math.min(maxY, UNIT - x);
            for (y = minY; y <= yloop; y++) {
                z = UNIT - x - y;

                count = 0;
                for (int i = 0; i < N; i++) {
                    loop++;
                    if (data[i][0] <= x && data[i][1] <= y && data[i][2] <= z) {
                        count++;
                    }
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.println("LOOP : " + loop);
        return maxCount;
    }
}

