package study;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class QTree {
	static int T;
	StringBuffer treestring = null;
	char value;
	
	QTree tree[] = new QTree[4];
	
	public QTree() {
		Arrays.fill(tree, null);
		
		if (treestring == null)
			treestring = new StringBuffer();
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc;
		
		
		sc = new Scanner(new FileInputStream("qtree.dat"));
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			String data = sc.next();
			QTree tree = new QTree();
			
			tree.reverse(data, 0);
			String result = tree.traverse();
			System.out.printf("%d: %s\n", test_case, result);
		}
		
		sc.close();
	}

	public int reverse(String data, int idx) {
		this.value = data.charAt(idx++);
		
		if (this.value != 'x')
			return idx;
		
		for (int i = 0; i < 4; i++)
		{
			this.tree[i] = new QTree();
		}
		
		idx = this.tree[2].reverse(data, idx);
		idx = this.tree[3].reverse(data, idx);
		idx = this.tree[0].reverse(data, idx);
		idx = this.tree[1].reverse(data, idx);
		
		return idx;
	}
	
	public String traverse() {
		treestring.append(this.value);
		
		if ( this.value != 'x' )
			return treestring.toString();
		
		for (int i = 0; i < 4; i++)
		{
			treestring.append(this.tree[i].traverse());
		}
		
		return treestring.toString();
	}
}
