import java.io.*;
import java.util.*;
import java.math.*;

public class Uva_10557_XYZZY
{
	public static long max(long a, long b)
	{
		if ( a > b) return a;
		return b;
	}
	public static void main(String[] args) throws IOException
	{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		Scanner input = new Scanner(System.in);
		String line, lines[];
		long arr[];
		int n, nN, nei;
		ArrayList<Integer> graph[];
		Queue<Integer> l;
		long sizes[];
		boolean visited[];
		boolean flag, flags[];
		long inf = -1000000000;
		long auxS;
		while( true ) 
		{
			n = input.nextInt();
			if ( n == -1 ) break;
			arr = new long[n+1];
			sizes = new long[n+1];
			visited = new boolean[n+1];
			graph = new ArrayList[n+1];
			for( int i = 0; i <= n; i++ )
			{
				graph[i] = new ArrayList<Integer>();
				sizes[i] = inf;
			}
			sizes[1] = 100;
			visited[1] = true;
			for( int i = 1; i <= n; i++ )
			{
				//lines = in.readLine().split(" ");
				arr[i] = input.nextLong();
				nN = input.nextInt();
				for( int j = 0; j < nN; j++ )
				{
					graph[i].add(input.nextInt());
				}
			}
			for( int i = 0; i <  n-1; i++ )
			{
				for( int j = 1; j <= n; j++ )
				{
					if ( visited[j] )
					{
						for( int k = 0; k < graph[j].size(); k++ )
						{
							nei = graph[j].get(k);
							auxS = sizes[j] + arr[nei];
							if ( auxS > 0)
							{
								sizes[nei] = max(sizes[nei], auxS );
								visited[nei] = true;
							}
							
						}
					}
				}
			}
			l = new LinkedList<Integer>();
			/*
			for( int i = 1; i <= n; i++ )
			{
				System.out.println(sizes[i]);
			}*/
			for( int j = 1; j <= n; j++ )
			{
				if ( visited[j] )
				{
					for( int k = 0; k < graph[j].size(); k++ )
					{
						nei = graph[j].get(k);
						auxS = sizes[j] + arr[nei];
						if ( auxS > 0 && auxS > sizes[nei] )
						{
							//System.out.println("en ciclos :"+nei);
							l.add(nei);	
						}
					}
				}
			}
			int auxNode;
			flag = false;
			flags = new boolean[n+1];
			while(!l.isEmpty())
			{
				auxNode = l.poll();
				if ( flags[auxNode] ) continue;
				flags[auxNode] = true;
				if ( auxNode == n)
				{
					flag = true;
					break;
				}
				for( int i = 0; i < graph[auxNode].size(); i++ )
				{
					l.add(graph[auxNode].get(i));
				}
			}
			if ( flag || visited[n])
			{
				out.append("winnable\n");
			}
			else
			{
				out.append("hopeless\n");
			}


		}
		System.out.print(out);
	}
}