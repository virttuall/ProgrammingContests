package uva;

import java.io.*;
import java.util.*;
import java.math.*;

public class Uva_3615_ProblemHIPTV {
	static int parent[];
	static void init( int n)
	{
		parent = new int[n];
		for ( int i = 0; i < n; i++ ) parent[i] = i;
	}
	static int find(int x) { return parent[x] = (x == parent[x]) ? x : find(parent[x]); }
	static void join(int x, int y) { parent[find(x)] = find(y); }
	static boolean disjoint(int x, int y) { return find(x) != find(y); }
	static class Edge implements Comparable<Edge>
	{
		int a, b, size;
		public Edge( int a, int b, int size)
		{
			this.a = a;
			this.b = b;
			this.size = size;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return new Integer(size).compareTo(o.size);
		}
	}
	static Edge[] kruskalAlgorithm( Edge[] graph, int nNodes)
	{
		Edge mst[] = new Edge[nNodes-1];
		int length = graph.length, count = 0;
		Edge auxEdge;
		PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
		for ( int i = 0; i<  length; i++ ) pQ.add(graph[i]);
		init(nNodes);
		while( !pQ.isEmpty())
		{
			auxEdge = pQ.poll();
			if (disjoint(auxEdge.a, auxEdge.b))
			{
				join(auxEdge.a, auxEdge.b);
				mst[count++] = auxEdge;
			}
		}
		return mst;
	}
	static int sizeMST(Edge[] mst)
	{
		int count = 0, length = mst.length;
		for ( int i = 0; i < length; i++ ) count += mst[i].size;
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in;
		StringBuilder out = new StringBuilder();
		File file = new File("in");
		if (file.exists())
			in = new BufferedReader(new FileReader(file));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		String line, lines[];
		int n = Integer.parseInt(in.readLine()), cities, links, countCity, a, b, size, aux;
		Map<String, Integer> map;
		Edge graph[];
		for ( int i = 0; i<  n; i++ )
		{
			in.readLine();
			cities = Integer.parseInt(in.readLine());
			links = Integer.parseInt(in.readLine());
			countCity = 0;
			graph = new Edge[links];
			init(cities);
			map = new HashMap<String, Integer>();
			for ( int j = 0; j < links; j++ )
			{
				lines = in.readLine().split(" ");
				if ( map.containsKey(lines[0])) a = map.get(lines[0]);
				else  map.put(lines[0], a = countCity++); 
				if ( map.containsKey(lines[1])) b = map.get(lines[1]); 
				else  map.put(lines[1], b = countCity++); 
				graph[j] = new Edge(a, b, Integer.parseInt(lines[2]));
			}
			if ( i != 0) out.append("\n");
			out.append(sizeMST(kruskalAlgorithm(graph, cities))+"\n");
		}
		System.out.print(out);
	}
}
