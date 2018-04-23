package study;

import java.io.FileInputStream;
import java.util.*;

public class CoreCity {

	static int data[][] = new int[1000 + 1][1000 + 1];
	static int visited[] = new int[1000 + 1];
	static int cntAdj[] = new int[1000 + 1];
//	static int fromNode[] = new int[1000 + 1];
	static int checkNode;
	static int V;
	static int E;
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc;

		int v1, v2;
		
		sc = new Scanner(new FileInputStream("corecity.dat"));
		
		int test_case = sc.nextInt();
		
		for ( int i = 1; i <= test_case; i++ )
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			Arrays.fill(cntAdj, 0);
			
			visited = new int[V + 1];
			
			for (int j = 1; j <= E; j++)
			{
				v1 = sc.nextInt();
				v2 = sc.nextInt();
				data[v1][cntAdj[v1] + 1] = v2;
				data[v2][cntAdj[v2] + 1] = v1;
				
				cntAdj[v1]++;
				cntAdj[v2]++;
			}
			
//			printData();
			
			printCoreCity();
			
//			System.out.printf("%d: ", i);
		}
	}
	
	private static void printCoreCity() {
		int cntCoreCity = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		checkNode = 1;
		
		System.out.println(checkCoreCity(checkNode, checkNode));
		
//		for (int i=1; i<=V; i++)
//		{
//			if (cntAdj[i] < 2 )
//				continue;
//
//			
//			Arrays.fill(visited, 0);
			
			
//			if ( checkCoreCity(i) == true )
//			{
//				cntCoreCity++;
//				list.add(i);
////				System.out.println("#### FOUND: " + (i+1));
//			}
//		}
		
//		System.out.printf("%d: ", cntCoreCity);
		
	}

	private static boolean checkCoreCity(int node, int fromNode) {
		int adj;
		
		System.out.printf("%d ", node);
		
		for(int i = 1; i < cntAdj[node]; i++)
		{
			adj = data[node][i];
			
			if ( visited[adj] == 1 )
				continue;
		
			visited[node] = 1;
			if ( checkCoreCity(adj, node) == false )
				return false;
			visited[node] = 0;
		}
		
		return true;
	}
	
//	private static boolean checkCoreCity(int core_node) {
//		int node;
//		int adjNode, prevNode;
//		
//		Deque<Integer> queue = new ArrayDeque<Integer>();
//		
//		
//		Arrays.fill(visited, 0);
//		Arrays.fill(fromNode, 0);
//		
//		queue.add(core_node);
//		
//		while(queue.isEmpty() == false)
//		{
//			node = (int)queue.pollFirst();
//			
//			if (visited[node] != 0)
//				continue;
//			
//			visited[node] = 1;
//			
//			for (int i = 1; i <= cntAdj[node]; i++)
//			{
//				adjNode = data[node][i];
//				
//				if (adjNode == core_node && core_node != fromNode[node])
//				{
//					return false;
//				}
//				
//				if (visited[adjNode] == 0)
//				{
//					queue.addLast(adjNode);
//					fromNode[adjNode] = node;
//				}
//			}
//		}
//		
//		return true;
//	}

	public static void printData()
	{
		for (int i=0; i<1000; i++)
		{
			if (cntAdj[i] > 0 )
				System.out.printf("%d: ",  i);
			
			for(int j=0; j < cntAdj[i]; j++)
				System.out.printf("%d ", data[i][j]);

			if (cntAdj[i] > 0 )
				System.out.println();
		}
	}
	
	
}

