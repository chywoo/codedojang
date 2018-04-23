package algorithm.sort;

import util.Timer;

/*
  소트 알고리즘 테스트
 */
public class BasicSort {

    public static int[] oriData= {855,2,229,663,31,28,4,66,99};


    int[] bubble(int[] data, int left, int right)
    {
        for (int i = 0; i < data.length; i++)
            for (int j = 1; j < data.length - i; j++)
                if (data[j - 1] > data[j]) swap(data, j - 1, j);

        return data;
    }

    int[] quick(int[] data, int left, int right)
    {
        int pivot = left;
        int i = left + 1;
        int j = left;

        if ( left >= right ) return data;


        for (; i <= right; i++) // start + 1부터 하는 이유는 start 위치가 pivot이기 때문
        {
            if ( data[i] < data[pivot] ) {
                j++;
                try {
                    swap(data, j, i);  // pivot과 위치가 겹치지 않게
                } catch ( Exception e )
                {
                    System.err.printf("\n#### %d, %d\n", j, i);

                    throw e;
                }
            }
        }

        swap(data, pivot, j); // pivot으로 쓰였던 start 위치의 값을 j 위치와 교환.
                              // 이유는 j - 1까지가 pivot보다 작은 값이니까.
                              // 이거 생각해 볼 것.

        quick(data, left, j - 1);
        quick(data, j + 1, right);

        return data;
    }

    int[] quick2(int[] data, int left, int right)
    {
        int pivot;
        int i;
        int j = left; // j를 배열 처음으로 지정하여, swap시 처음부터 바뀌게, 그래서 말미에 swap(data, pivot, j)를 안 하게 해 볼 것.

        if ( left >= right ) return data;


        pivot = data[left];

        for (i = left + 1; i <= right; i++) // start + 1부터 하는 이유는 start 위치가 pivot이기 때문
        {
            if ( data[i] < pivot ) {
                try {
                    swap(data, j++, i);  // pivot과 위치가 겹치지 않게
                } catch ( Exception e )
                {
                    System.err.printf("\n#### %d, %d\n", j, i);

                    throw e;
                }
            }
        }

        quick2(data, left, j - 1);
        quick2(data, j + 1, right);

        return data;
    }

    void swap(int[] data, int a, int b)
    {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    void printLines(float time, int[] data)
    {
        System.out.printf("%fs: ", time);

        for (int i = 0; i < data.length - 1; i++) {
            System.out.printf("%d, ", data[i]);

        }

        System.out.println(data[data.length - 1]);
    }


    public static void main(String[] args)
    {
        int[] data;
        float time;

        BasicSort sort = new BasicSort();

        Timer.start();

        data = oriData.clone();

        sort.bubble(data, 0, oriData.length - 1);
        time = Timer.end();

        sort.printLines(time, data);

        Timer.start();

        data = oriData.clone();

        sort.quick2(data, 0, oriData.length - 1);
        time = Timer.end();

        sort.printLines(time, data);
0
    }
}
