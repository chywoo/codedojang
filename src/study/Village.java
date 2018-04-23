package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Village {
    static int T,N,M;
    static int[][] Hw;
  
    static int Answer;
  
    static long Start,End;
  
    static int group;
  
    static ArrayList<Integer> adjList = new ArrayList<Integer>(); // 해당 거점의 상위 거점 저장
  
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("village.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());
   
        for(int test_case = 1; test_case <= T; test_case++){
            Start = System.currentTimeMillis();
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());
            Hw = new int[M][2];
            Answer = Integer.MAX_VALUE;
    
            for(int i=0;i<M;i++){
                String temp[] = br.readLine().trim().split(" ");
                Hw[i][0] = Integer.parseInt(temp[0])*(N+1)+Integer.parseInt(temp[1]);
                Hw[i][1] = Integer.parseInt(temp[2]);
            }
    
            // 비용 내림 차순으로 정렬
            Arrays.sort(Hw,new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
    
            //System.out.println(Arrays.deepToString(Hw));
            adjList.clear();
            for(int k = 0; k < N+1; k++) {
                adjList.add(0);
            } 
    
            //비용이 비싼 도로부터 연결해서 모든 거점이 연결되는 순간 최대/최소 차이를 Answer에 저장
            //제일비싼 도로는 제외하고 다시 탐색
            for(int i=0;i<M;i++){
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < N+1; k++) {
                    adjList.set(k,0);
                }   
                group = 0;
                for(int j=i;j<M;j++){
                    int st = Hw[j][0]/(N+1);
                    int end = Hw[j][0]%(N+1);
                    int cost = Hw[j][1];
                    // 도로를 최소한으로 연결하기 위한 사이클 여부 판단    
                    if(adjList.get(st) == 0 && adjList.get(end) == 0){
                        // 두 거점 중 작은 값을 parent로 설정.
                        group++;
                        adjList.set(st, Math.min(st, end));
                        adjList.set(end, Math.min(st, end));
                        if(max < cost) max = cost;
                        if(min > cost) min = cost;
                    }
                     
                    //앞처음 뒤발견 때 
                    // 처음 발견 거점의 Parent 기발견된 거점 최상위 Parent로 설정
                    else if(adjList.get(st) == 0 && adjList.get(end) != 0){
                        group++;
                        adjList.set(st, findParent(end));
                        if(max < cost) max = cost;
                        if(min > cost) min = cost;              
                    }
                    //앞발견 뒤처음 때
                    // 처음 발견 거점의 Parent 기발견된 거점 최상위 Parent로 설정
                    //adjList[뒤] = adjList[앞]
                    else if(adjList.get(st) != 0 && adjList.get(end) == 0){
                        group++;
                        adjList.set(end, findParent(st));
                        if(max < cost) max = cost;
                        if(min > cost) min = cost;       
                    }  
                    //둘다 발견시
                     
                    else if(adjList.get(st) != 0 && adjList.get(end) != 0){
                        // 둘의 최상위 거점이 다른 경우 최상위 거점 중 큰값을 가진 거점의 Parent를 작은 최상위 Parent로 업데이트
                        int parent1 = findParent(st);
                        int parent2 = findParent(end);      
                        if(parent1 != parent2){
                            group++;
                            if(parent1 < parent2) {
                                adjList.set(end, parent1);
                            }
                            else {
                                adjList.set(st, parent2);
                            }
                            if(max < cost) max = cost;
                            if(min > cost) min = cost;
                        }
                        // 두 거점의 최상위 거점이 동일하면 사이클이므로 연결하지 않음.
                        else {
                            continue;
                        }
                    }     
                    //전체거점이 연결되었을 때 최대/최소 차이가 기존 Answer 보다 작을 때 Answer 저장
                    if(group == N-1) {
                        if(Answer > max-min) Answer = max-min;
                        break;
                    }    
                    //System.out.println("af "+i+":"+st+","+end+","+cost);
                }   
            }
            End = System.currentTimeMillis();
            System.out.println("#"+test_case+" "+Answer+"   "+(End-Start)/1000);
        }
   
    }
  
    static int findParent(int child){
        if(adjList.get(child) == child)  return child;
        return findParent(adjList.get(child));
    }
}