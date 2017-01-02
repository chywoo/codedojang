package pro;

import util.Timer;

import java.io.*;
import java.util.*;

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
    static public int[] data;
    static public ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            Answer = Count = 0;
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
            for (int i : list)
            	System.out.printf("(%d, %d) ",  data[(int)i/1000], data[i % 1000]);
            
            System.out.println();
        }

        sc.close();
    }

    private static int solve() {
        int swapCount = 0, maxCount = 0;

        for (int last = N - 1; last > 0; last--) {
            for (int first = 0; first < last; first++) {
            	if ( data[first] <= data[last] ) continue;
            	
                // SWAP의 개수 계산
                swapCount = calcSwap(first, last);

                if (swapCount > maxCount) {
                    maxCount = swapCount;
                    Count = 1;
                    list.clear();
                    list.add(first * 1000 + last);
                }
                else if ( swapCount == maxCount ) {
                    Count++;
                    list.add(first * 1000 + last);
                }
            }
        }
        return maxCount;
    }

    private static int calcSwap(int first, int last) {
        int count = 0;
        int value;

        value = data[first];

        for(int i = first + 1; i < last; i++)
        {
            if ( data[i] < value ) count++;
            else if ( data[i]  > value ) count--;
        }

        value = data[last];
        for(int i = last - 1; i > first; i--)
        {
            if ( data[i] > value ) count++;
            else if ( data[i] < value ) count--;
        }

        return count;
    }

}
