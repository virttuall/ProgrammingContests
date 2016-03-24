import java.io.*;
import java.util.*;
import java.math.*;

public class Uva_11280_FlyingToFredericton
{
	public static long min( long a, long b)
	{
		if ( a < b ) return a;
		return b;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		int nCases = Integer.parseInt(in.readLine());
		int n, m, a, b, s, q, v, nei, neiS;
		String line, lines[];
		HashMap<String, Integer> map;
		ArrayList<Integer> graph[], graphS[];
		long sizes[][], inf = 1000000000l, result;
		int set = 1;
		for( int nC = 0; nC < nCases; nC++ )
		{
			in.readLine();
			n = Integer.parseInt(in.readLine());
			map = new HashMap<String, Integer>();
			graph = new ArrayList[n];
			graphS = new ArrayList[n];
			sizes = new long[n][n];
			for( int i = 0; i < n; i++ )
			{
				map.put(in.readLine(), i);
				graph[i] = new ArrayList<Integer>();
				graphS[i] = new ArrayList<Integer>();
				Arrays.fill(sizes[i], inf);
			}
			sizes[0][0] = 0;
			m = Integer.parseInt(in.readLine());
			for( int i = 0; i < m; i++ )
			{
				lines = in.readLine().split(" ");
				a = map.get(lines[0]);
				b = map.get(lines[1]);
				s = Integer.parseInt(lines[2]);
				graph[a].add(b);
				graphS[a].add(s);
			}
			for( int i = 0; i < n-1; i++ )
			{
				for( int j = 0; j < n; j++ )
				{
					for( int k = 0; k < graph[j].size(); k++ )
					{
						nei = graph[j].get(k);
						neiS = graphS[j].get(k);
						sizes[i+1][nei] = min( sizes[i+1][nei], sizes[i][j] + (long)(neiS) );
					}
				}
				for( int j = 0; j < n; j++ )
				{
					sizes[i+1][j] = min(sizes[i+1][j], sizes[i][j]);
				}
			}
			lines = in.readLine().split(" ");
			q = Integer.parseInt(lines[0]);
			out.append("Scenario #"+set+"\n");
			for( int i = 0; i < q; i++ )
			{
				v = Integer.parseInt(lines[1+i]);
				result = sizes[(int)(min(n-1, v+1))][n-1];
				if ( result == inf )
				{
					out.append("No satisfactory flights\n");
				}
				else
				{
					out.append("Total cost of flight(s) is $"+result+"\n");
				}
			}
			if ( set != nCases) out.append("\n");
			set++;
		}
		System.out.print(out);
	}
}