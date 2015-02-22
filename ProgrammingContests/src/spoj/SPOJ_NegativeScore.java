package spoj;

// Accepted

import java.io.*;
import java.util.*;
import java.math.*;
public class SPOJ_NegativeScore {
static int arr[];
static class Node
{
	int size;
	Node right, left;
	int init, finish, mid;
}
static void buildST( int init, int finish, Node root)
{
	root.init = init;
	root.finish = finish;
	root.mid =  (finish + init)/2;
	root.size = Integer.MAX_VALUE;
	if ( init != finish)
	{
		root.left = new Node();
		root.right = new Node();
		buildST(init , root.mid, root.left);
		buildST(root.mid + 1, finish, root.right);
	}
	else
	{
		root.size = arr[init-1];
	}
}
static int uptadeMax( Node root)
{
	if ( root.init == root.finish ) return root.size;
	root.size = maxI( uptadeMax(root.right), uptadeMax(root.left));
	return root.size;
}
static int query( int a, int b, Node nod)
{
	if ( a == nod.init && b == nod.finish )  return nod.size;
	int max = Integer.MIN_VALUE;
	if ( a <= nod.mid) max = query(a,minI(nod.mid, b) , nod.left);
	if ( b >= nod.mid + 1) max = maxI(max, query(maxI(a, nod.mid + 1), b, nod.right));
	return max;
}
static int maxI( int a, int b)
{
	int max = a;
	if ( b > a) max = b;
	return max;
}
static int minI( int a, int b)
{
	int min = a;
	if ( b < a) min = b;
	return min;
}
public static int[] parseInts(String line) {
	String lines[] = line.split(" ");
	int n = lines.length;
	int r[] = new int[n];
	for (int i = 0; i < n; i++) {
		r[i] = -1 * Integer.parseInt(lines[i]);
	}
	return r;
}
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	Node root;
	int t = Integer.parseInt(in.readLine()), n, q;
	for ( int i = 0; i < t; i++ )
	{
		lines = in.readLine().split(" ");
		n = Integer.parseInt(lines[0]);
		q = Integer.parseInt(lines[1]);
		arr = parseInts(in.readLine());
		out.append("Scenario #"+(i+1)+":\n\n");
		root = new Node();
		buildST( 1 , n, root);
		uptadeMax(root);
		for ( int j = 0; j < q; j++ )
		{
			lines = in.readLine().split(" ");
			out.append(-1*query(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), root)+"\n");
		}
		
	}
	System.out.print(out);
}
}
