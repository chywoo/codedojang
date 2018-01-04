package examples;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class juice {
    //private static int MAX_SIZE = 10000;
    //private static int MAX_PEOPLE = 100;
     
    class Cocktail {
        public int u1, u2, u3;
         
        public Cocktail( int u1, int u2, int u3) {
            this.u1 = u1;          
            this.u2 = u2;          
            this.u3 = u3;          
        }
    };
     
    // 3중 루프를 돌려서 모든 가능한 조합의 최대값을 구한다.
    int process(Cocktail peoples[], int peopleCnt, int cocktailSize) {
        int max = 0;
 
        for(int i = 0; i <= cocktailSize; i++) {
            int cnt2 = cocktailSize - i;
            for (int j = 0; j <= cnt2; j++) {
                int k = cocktailSize - i - j;
                 
                int cnt = 0;
                for(int n = 0; n < peopleCnt; n++) {
                    Cocktail pp = peoples[n];
                    if(pp.u1 <= i && pp.u2 <= j && pp.u3 <= k) {
                        cnt ++;
                    }
                }
                 
                if(cnt > max) {
                    max = cnt;
                }
            }
        }
  
        return max;
    }
     
    // 첫번째 루프의 중간 구간을 가지치기 하고, 탐색할 사람들의 limit를 제한한다.
    int process2(Cocktail peoples[], int peopleCnt, int cocktailSize) {
        int max = -1;
 
        Arrays.sort(peoples, new Comparator<Cocktail>() {
            @Override
            public int compare(Cocktail o1, Cocktail o2) {
                return Integer.compare(o1.u1, o2.u1);
            }          
        });
         
        for (int edIdx = 0; edIdx < peopleCnt; edIdx++) {
            int i = peoples[edIdx].u1;
             
            int cnt2 = cocktailSize - i;
            for (int j = 0; j <= cnt2; j++) {
                int k = cocktailSize - (i + j);
 
                int cnt = 0;
                for(int n = 0; n <= edIdx; n++) {
                    Cocktail pp = peoples[n];
                    if(pp.u2 <= j && pp.u3 <= k) {
                        cnt ++;
                    }
                }
                 
                if(cnt > max) {
                    max = cnt;
                }
            }
        }
         
        return max;
    }
  
    // 첫번째 루프의 중간 구간을 가지치기 하고, 탐색할 사람들의 limit를 제한한다. 추가로 2, 3번째 음료 유닛을 이용해 루프 최적화를 한다.
    int process3(Cocktail peoples[], int peopleCnt, int cocktailSize) {
        int max = -1;
 
        Arrays.sort(peoples, new Comparator<Cocktail>() {
            @Override
            public int compare(Cocktail o1, Cocktail o2) {
                return Integer.compare(o1.u1, o2.u1);
            }          
        });
         
        Cocktail[] peoples2 = peoples.clone();
        Arrays.sort(peoples2, new Comparator<Cocktail>() {
            @Override
            public int compare(Cocktail o1, Cocktail o2) {
                return Integer.compare(o1.u2, o2.u2);
            }          
        });
        int[] u2x = new int[cocktailSize + 1];
        int curIdx = 0;
        for( int i = 0; i <= cocktailSize; i++) {
            while(curIdx < peopleCnt && i >= peoples2[curIdx].u2){
                curIdx ++;
            }
            u2x[i] = curIdx;
        }
         
        peoples2 = peoples.clone();
        Arrays.sort(peoples2, new Comparator<Cocktail>() {
            @Override
            public int compare(Cocktail o1, Cocktail o2) {
                return Integer.compare(o1.u3, o2.u3);
            }          
        });
        int[] u3x = new int[cocktailSize + 1];
        curIdx = 0;
        for( int i = 0; i <= cocktailSize; i++) {
            while(curIdx < peopleCnt && i >= peoples2[curIdx].u3){
                curIdx ++;
            }
            u3x[i] = curIdx;
        }
         
        for (int edIdx = 0; edIdx < peopleCnt; edIdx++) {
            int i = peoples[edIdx].u1;
             
            int cnt2 = cocktailSize - i;
            for (int j = 0; j <= cnt2; j++) {
                int k = cocktailSize - (i + j);
 
                if(max >= 0 && (u2x[j] < max || u3x[k] < max)) {
                    continue;
                }                  
                 
                int cnt = 0;
                for(int n = 0; n <= edIdx; n++) {
                    Cocktail pp = peoples[n];
                    if(pp.u2 <= j && pp.u3 <= k) {
                        cnt ++;
                    }
                }
                 
                if(cnt > max) {
                    max = cnt;
                }
            }
        }
         
        return max;
    }
  
    // 각 사람들의 요구사항을 입력으로 제한한다.
    int process4(Cocktail peoples[], int peopleCnt, int cocktailSize) {
        int max = 0;
 
        for (int i = 0; i < peopleCnt; i++) {
            int u1 = peoples[i].u1;
            for (int j = 0; j < peopleCnt; j++) {
                int u2 = peoples[j].u2;
                if(u1 + u2 > cocktailSize) {
                    continue;
                }
                int u3 = cocktailSize - (u1 + u2);
                 
                int cnt = 0;
                for (int k = 0; k < peopleCnt; k++) {
                    if (u1 >= peoples[k].u1 && u2 >= peoples[k].u2 && u3 >= peoples[k].u3) {
                        cnt++;
                    }
                }
                 
                if(cnt > max) {
                    max = cnt;
                }
            }
        }
         
        return max;
    }
  
    @SuppressWarnings("resource")
    public void proc() {
        //Scanner scan = new Scanner(System.in); // for jungol
        Scanner scan;
        try {
            scan = new Scanner(getClass().getResource("input.txt").openStream());
        } catch (IOException e) {
            System.out.println("input file not found");
            return;
        }
 
        int cocktailSize = scan.nextInt();
        int peopleCnt = scan.nextInt();
  
        Cocktail[] peoples = new Cocktail[peopleCnt];
        for(int i = 0; i < peopleCnt; i++) {
            int u1 = scan.nextInt();
            int u2 = scan.nextInt();
            int u3 = scan.nextInt();
             
            peoples[i] = new Cocktail(u1, u2, u3);
        }
 
//cocktailSize = 10000;
//peopleCnt = 100;
//peoples = new Cocktail[peopleCnt];
//for(int i = 0; i < peopleCnt; i++) {
//  int u1 = (int)(Math.random() * cocktailSize/3);
//  int u2 = (int)(Math.random() * (cocktailSize - u1));
//  int u3 = (int)(Math.random() * (cocktailSize - (u1 + u2)));
// 
//  peoples[i] = new Cocktail(u1, u2, u3);
//}
 
        long startTick = System.currentTimeMillis();
        int max = process(peoples, peopleCnt, cocktailSize);
        long endTick = System.currentTimeMillis();
        System.out.println("method #1 : max people = " + max + "  take time (ms) : " + (endTick - startTick));
         
        long startTick2 = System.currentTimeMillis();
        int max2 = process2(peoples, peopleCnt, cocktailSize);
        long endTick2 = System.currentTimeMillis();
        System.out.println("method #2 : max people = " + max2 + "  take time (ms) : " + (endTick2 - startTick2));
         
        long startTick3 = System.currentTimeMillis();
        int max3 = process3(peoples, peopleCnt, cocktailSize);
        long endTick3 = System.currentTimeMillis();
        System.out.println("method #3 : max people = " + max3 + "  take time (ms) : " + (endTick3 - startTick3));
         
        long startTick4 = System.currentTimeMillis();
        int max4 = process4(peoples, peopleCnt, cocktailSize);
        long endTick4 = System.currentTimeMillis();
        System.out.println("method #4 : max people = " + max4 + "  take time (ms) : " + (endTick4 - startTick4));
         
        //System.out.println(max3);  // for jungol
    }
  
    public static void main(String[] argv) {
        juice sol = new juice();
        sol.proc();
    }
}