import java.io.*;
import java.math.*;
import java.util.*;
public class Uva_11234_Expressions {
	public static class Node
	{
		char value;
		Node l = null, r = null;
		public Node(char v)
		{
			value = v;
		}
	}
	public static class V implements Comparable<V>
	{
		char value;
		int level;
		int ll;
		public V( char v, int le, int l)
		{
			value = v;
			level = le;
			ll = l;
		}
		@Override
		public int compareTo(V o) {
			// TODO Auto-generated method stub
			if ( o.level == level ) return new Integer(ll).compareTo(o.ll);
			return -1 * new Integer(level).compareTo(o.level);
		}
	}
	public static int count;
	public static ArrayList<V> list;
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	int n = Integer.parseInt(in.readLine());
	Stack<Node> stack;
	char[] arr;
	for( int t = 0; t < n; t++ )
	{
		arr = in.readLine().trim().toCharArray();
		stack = new Stack<Node>();
		count = 0;
		list = new ArrayList<V>();
		for( int i = 0; i < arr.length; i++ )
		{
			if ( arr[i] <= 'z'  && arr[i] >= 'a')
			{
				stack.push(new Node(arr[i]));
			}
			else
			{
				Node node = new Node(arr[i]);
				node.r = stack.pop();
				node.l = stack.pop();
				stack.push(node);
			}
		}
		f(stack.pop(), 0);
		Collections.sort(list);
		for( int i = 0; i < list.size(); i++ )
		{
			out.append(list.get(i).value);
		}
		out.append("\n");
	}
	System.out.print(out);
}
public static void f(Node n, int l)
{

	if ( n.l != null)
	{
		f(n.r, l+1);
		f(n.l, l+1);
	}
	list.add(new V(n.value, l+1, ++count));
}
}
