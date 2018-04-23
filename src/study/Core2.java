package study;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Core2 {
	static int V = 1000;
	static int[] discovered = new int[V];
	static ArrayList<Integer>[] adjList = new ArrayList[V];
	static ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		setDataList();
		long startTime = System.currentTimeMillis();
		for (int i = 1; i < V; i++) {
			Arrays.fill(discovered, 0);
			discovered[0] = 1;
			bfs(i);
			if (!isAllFill(discovered)) {
				System.out.println(i);
			}
		}
		System.out.println("time = " + (System.currentTimeMillis() - startTime) + "ms");
	}

	public static void bfs(int skipIndex) {
		int node;
		if (skipIndex != 1) {
			queue.add(1);
			discovered[1] = 1;
		} else {
			queue.add(2);
			discovered[2] = 1;
		}
		
		discovered[skipIndex] = 1;
		while ( !queue.isEmpty() ) {
			node = queue.pollFirst();
			if (adjList[node] != null) {
				for (int adjacent : adjList[node]) {
					if (discovered[adjacent] == 0) {
						queue.add(adjacent);
						discovered[adjacent] = 1;
					}
				}
			}
		}
	}

	public static boolean isAllFill(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				return false;
			}
		}
		return true;
	}

	public static void setDataList() {
//		int fillCnt = 0;
//		for (int i = 1; i < V; i++) {
//			for (int j = i + 1; j < V; j += 10) {
//				if (i == 49 || j == 50) {
//					continue;
//				}
//				adjList[i].add(j);
//				fillCnt++;
//			}
//		}
//		adjList[49].add(50);
//		System.out.println("roadCnt = " + fillCnt);
		 adjList[1].add(2);
		 adjList[1].add(4);
		
		 adjList[2].add(1);
		 adjList[2].add(3);
		 adjList[2].add(6);
		
		 adjList[3].add(2);
		 adjList[3].add(4);
		
		 adjList[4].add(1);
		 adjList[4].add(3);
		 adjList[4].add(5);
		
		 adjList[5].add(4);
		
		 adjList[6].add(2);
		 adjList[6].add(7);
		 adjList[6].add(8);
		
		 adjList[7].add(6);
		 adjList[7].add(8);
		 adjList[7].add(9);
		
		 adjList[8].add(6);
		 adjList[8].add(7);
		 adjList[8].add(9);
		
		 adjList[9].add(7);
		 adjList[9].add(8);
		 adjList[9].add(10);
		
		 adjList[10].add(9);
	}
}