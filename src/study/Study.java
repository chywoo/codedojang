package study;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Study {

	public static void main(String[] args)
	{
		LinkedList<String> deque;
		
		deque = new LinkedList<String>();
		
		deque.addFirst("a");
		deque.push("b");
		deque.push("c");
		deque.add("e");
//		deque.poll();
		deque.pop();
		
		Collections.sort(deque, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		for (String data : deque )
			System.out.printf("%s, ", data);
		
	}
}
