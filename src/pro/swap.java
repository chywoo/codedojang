package pro;

import util.Timer;

import java.util.ArrayList;

/**
 * Created by chywoo.park on 2017. 1. 2..
 */
public class swap {

    public static String input = "4\n" +
        "5 " +
        "1 2 3 4 5 " +
        "5 " +
        "1 4 3 5 2 " +
        "5 " +
        "2 1 4 3 5 " +
        "5 " +
        "5000 5000 3000 3000 1000";

    static public int T;
    static public int N, Answer, Count;
    static public int maxCount;
    static public int[] data;
    static public ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            Answer = Count = maxCount = 0;
            list.clear();

            N = sc.nextInt();

            data = new int[N];

            for(int i=0; i<N; i++)
            {
                data[i] = sc.nextInt();
            }

            Timer.start();
            Answer = solve();

            System.out.printf("#%d: %d %d, %fs\n", test_case, Answer, Count, Timer.end());
        }

        sc.close();
    }

    private static int solve() {
        int swapCount;
        int pairCount = 0;

        int distance = 0; // 두 숫자간의 거리. 거리가 가까우면 swapCount가 작을 수밖에 없음

        for (int last = N - 1; i > 0; i--) {
            for (int first = 0; first < last; first++) {
                if (data[first] > data[last]) {
                    // Swap 개수 계산
                    swapCount = calcSwap(first, last);

                    if (swapCount > maxCount) {
                        maxCount = swapCount;
                        pairCount = 1;
                    }
                    else if ( swapCount == maxCount )
                        pairCount++;
                }
            }
        }
        return 0;
    }

    private static int calcSwap(int first, int last) {
        return 0;
    }

}
