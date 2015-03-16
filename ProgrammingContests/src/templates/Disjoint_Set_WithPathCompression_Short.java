package templates;

import java.util.Arrays;

public class Disjoint_Set_WithPathCompression_Short {
	static int parent[];
	static void init( int n)
	{
		parent = new int[n];
		for ( int i = 0; i < n; i++ ) parent[i] = i;
	}
	static int find(int x) { return parent[x] = (x == parent[x]) ? x : find(parent[x]); }
	static void join(int x, int y) { parent[find(x)] = find(y); }
	static boolean disjoint(int x, int y) { return find(x) != find(y); }
	public static void main(String[] args) {
		init(10);
		join(0, 1);
		join(2, 1);
		System.out.println(disjoint(0,3));
		join(2, 3);
		System.out.println(disjoint(0,3));
	}
}
