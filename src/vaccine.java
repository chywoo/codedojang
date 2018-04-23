import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.*;

public class vaccine {

	static int N;
	static int M;
	static int Answer;
	static ArrayList<Integer>[] rel;
	static HashSet<Integer> setPerson = new HashSet<Integer>();
	
	static ArrayList<Integer> debug = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("vaccine.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 읽기

		for (int test_case = 1; test_case <= T; ++test_case) {

			/******************************************************/

			// 이 곳에 알고리즘을 구현합니다.

			/******************************************************/
			// 입력
			Answer = solve(sc);
			// 출력

			System.out.printf("#%d %d\n", test_case, Answer);
		}
		
		sc.close();
	}

	public static int solve(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
//		Marr = new int[N + 1][N + 1];
		int minDepth = N;
		
		rel = new ArrayList[N + 1];
		for (int i=0; i<=N; i++)
			rel[i] = new ArrayList<Integer>();
		
		for (int i=0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			rel[a].add(b);
			rel[b].add(a);
		}
		
		for (int i=1; i<=N; i++)
		{
			setPerson.clear();
			rel[0].clear();
			rel[0].add(i);
			
			int depth = maketree(0, 0);
			minDepth = (minDepth > depth) ? depth : minDepth;
				
			
		}
		
		return minDepth;
	}

	private static int maketree(int i, int level) {
		int depth = level;
		ArrayList<Integer> child = new ArrayList<Integer>();
		Set<Integer> newPerson = new HashSet<Integer>(); 
		
		
		newPerson.addAll(rel[i]);
		newPerson.removeAll(setPerson);
		
		setPerson.addAll(rel[i]);
		debug.add(i);
		
		
		if (setPerson.size() != N)
		{
			Iterator p = newPerson.iterator();
			
			while(p.hasNext())
			{
				depth = maketree((int)p.next(), level + 1);
				break;
			}
		}
		else
			System.out.println("*** PATH" + debug.toString());
		
		
		debug.remove(debug.size() - 1);
		return depth;
	}

}
