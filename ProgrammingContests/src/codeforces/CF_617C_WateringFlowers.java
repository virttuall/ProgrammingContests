import java.io.*;
import java.math.*;
import java.util.*;
public class CF_617C_WateringFlowers {
	static class Node implements Comparable<Node>
	{
		int index;
		long value;
		public Node(int i, long v)
		{
			index = i;
			value = v;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return new Long(value).compareTo(o.value);
		}
		public String toString()
		{
			return index+" _ "+value;
		}
	}
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	lines = in.readLine().split("\\s+");
	int n;
	long  x1, y1, x2, y2;
	long xs[], ys[];
	n = Integer.parseInt(lines[0]);
	x1 = Long.parseLong(lines[1]);
	y1 = Long.parseLong(lines[2]);
	x2 = Long.parseLong(lines[3]);
	y2 = Long.parseLong(lines[4]);
	xs = new long[n];
	ys = new long[n];
	Node[] valuesf = new Node[n];
	Node[] valuess = new Node[n];
	for( int i = 0; i < n; i++ )
	{
		lines = in.readLine().split("\\s+");
		xs[i] = Long.parseLong(lines[0]);
		ys[i] = Long.parseLong(lines[1]);
		valuesf[i] = new Node(i, (x1-xs[i])*(x1-xs[i])+(y1-ys[i])*(y1-ys[i]));
		valuess[i] = new Node(i, (x2-xs[i])*(x2-xs[i])+(y2-ys[i])*(y2-ys[i]));
	}
	Arrays.sort(valuesf);
	Arrays.sort(valuess);
	long min1 = valuesf[n-1].value;
	long min2 = valuess[n-1].value;
	long max1 = Long.MIN_VALUE;
	long max2 = Long.MIN_VALUE;
	int index1, index2;
	for( int i = n-1; i >= 1; i--)
	{
		index1 = valuesf[i].index;
		index2 = valuess[i].index;
		max1 = max(max1, (x2-xs[index1])*(x2-xs[index1])+(y2-ys[index1])*(y2-ys[index1]));
		max2 = max(max2, (x1-xs[index2])*(x1-xs[index2])+(y1-ys[index2])*(y1-ys[index2]));
		min1 = min(min1, max1 + valuesf[i-1].value);
		min2 = min(min2, max2 + valuess[i-1].value);
	}
	System.out.println(min(min1, min2));
}
public static long min(long a, long b)
{
	if ( a < b) return a;
	return b;
}
public static long max(long a, long b)
{
	if ( a > b) return a;
	return b;
}
}