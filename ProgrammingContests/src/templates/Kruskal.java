package templates;
import java.io.*;
import java.util.*;
import java.math.*;
public class Kruskal {
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
public static void main(String[] args) {
	Edge graph[] = new Edge[7];
	graph[0] = new Edge(0, 1, 4);
	graph[1] = new Edge(1, 2, 2);
	graph[2] = new Edge(0, 2, 4);
	graph[3] = new Edge(0, 3, 6);
	graph[4] = new Edge(2, 3, 8);
	graph[5] = new Edge(0, 4, 6);
	graph[6] = new Edge(3, 4, 9);
	Edge mst[] = kruskalAlgorithm(graph, 5);
	for ( int i = 0; i<  mst.length; i++ ) System.out.println(mst[i].a  + " " + mst[i]. b + " " + mst[i].size);
}
}
