package uva;

import java.io.*;
import java.util.*;
import java.math.*;
class UVA_12507_Kingdoms
{
	static class Node implements Comparable<Node>
	{
		int node, value, father;
		public Node( int _node, int _value, int _father)
		{
			node = _node;
			value = _value;
			father = _father;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return new Integer(value).compareTo(o.value);
		}
		public String toString()
		{
			return "node: "+node + ", value: " + value + " father: " + father;
		}
		
	}
	public static int[] parseI(String s)
	{
		String[] arr = s.split(" ");
		int[] res = new int[arr.length];
		for ( int i= 0; i < res.length; i++ )
		{
			res[i] = Integer.parseInt(arr[i]);
		}
		return res;
	}
	public static int min( int a, int b)
	{
		if ( a < b) return a;
		return b;
	}
	public static void main (String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		int cases = Integer.parseInt(in.readLine());
		int graph[][], n, m, k, populations[], u, v, c,aux, oo = -1, maxPopulation = -1, count, countMoney;
		String lines[];
		PriorityQueue<Node> priorityQueue;
		boolean visited[],require[];
		Node nodeAux;
		for ( int casess = 0; casess < cases; casess++ )
		{
			lines = in.readLine().split(" ");
			n = Integer.parseInt(lines[0]);
			m = Integer.parseInt(lines[1]);
			k = Integer.parseInt(lines[2]);
			graph = new int[n+1][n+1];
			for ( int i = 1; i <= n; i++ ) for ( int j = 1; j <= n; j++ ) graph[i][j] = oo;
			populations = parseI(in.readLine());
			for ( int i = 0; i <m; i++ )
			{
				lines = in.readLine().split(" ");
				u = Integer.parseInt(lines[0]);
				v = Integer.parseInt(lines[1]);
				c = Integer.parseInt(lines[2]);
				if ( graph[u][v] == -1)
				{
					graph[u][v] = c;
					graph[v][u] = c;
				}
				else
				{
					aux =  min(graph[u][v], c);
					graph[u][v] = aux;
					graph[v][u] = aux;
				}
			}
			maxPopulation = 0;
			for ( int i = (1 << (n-1))+1; i <= (1 << n) -1; i++  )
			{
				count = 0;
				countMoney = 0;
				require = new boolean[n+1];	
				for ( int j = 0; j < n; j++ ) if ( (i >> j) % 2 == 1) { require[n-j] = true; }
				visited = new boolean[n+1];
				priorityQueue = new PriorityQueue<Node>();
				priorityQueue.add(new Node(1, 0, 0));
				while( !priorityQueue.isEmpty())
				{
					nodeAux = priorityQueue.remove();
					
					if ( visited[nodeAux.node]) continue;
					visited[nodeAux.node] = true;
					count += populations[nodeAux.node-1];
					countMoney += nodeAux.value;
					for ( int j = 1; j <= n; j++ )
					{
						if ( graph[nodeAux.node][j] != -1 && !visited[j] && require[j])
						{
							priorityQueue.add(new Node(j,graph[nodeAux.node][j], nodeAux.node));
						}
					}
				}
				if ( count > maxPopulation && countMoney <= k)
					maxPopulation = count;
			}
			out.append(maxPopulation+"\n");
		}
		System.out.print(out);
	}
}