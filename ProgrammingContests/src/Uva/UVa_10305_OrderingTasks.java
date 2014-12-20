package Uva;

import java.io.*;
import java.util.*;


public class UVa_10305_OrderingTasks {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder out = new StringBuilder("");
	static String line, lines[];
	static List<Integer> list;
	static int n, m, i, j;
	static boolean graph[][], visited[];
    public static void TopologySort(int a)
    {
    	visited[a] = true;
    	for ( int k = 0; k < n; k++ )
    	{
    		if ( graph[a][k] && !visited[k])
    		{
    			TopologySort(k);
    		}
    	}
    	list.add(a);
    }
	public static void main(String[] args) throws IOException {
		
		while( !(line = in.readLine()).equals("0 0") )
		{
			lines = line.split("\\s+");
			n = Integer.parseInt(lines[0]);
			m = Integer.parseInt(lines[1]);
			graph = new boolean[n][n];
			visited = new boolean[n];
			list  = new ArrayList<Integer>();
			for ( int k = 0; k < m; k++ )
			{
				lines = in.readLine().split("\\s+");
				i = Integer.parseInt(lines[0]);
				j = Integer.parseInt(lines[1]);
				graph[i-1][j-1] = true;
			}
			for ( int k = 0; k < n; k++ )
			{
				if ( !visited[k] )
				{
					TopologySort(k);
				}
			}
			for ( int k = list.size()-1; k > -1; k-- )
			{
				out.append(list.get(k)+1);
				if ( k != 0) out.append(" ");
			}
			out.append("\n");
		}
		System.out.print(out);
	}
}
