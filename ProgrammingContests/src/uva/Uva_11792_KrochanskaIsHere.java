//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2892
import java.io.*;
import java.math.*;
import java.util.*;
public class Uva_11792_KrochanskaIsHere {
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	int t = Integer.parseInt(in.readLine());
	int n, s;
	int values[][];
	int is[], nis, graph[][], mapN[], mapI[];
	for( int tt = 0; tt < t; tt++ )
	{
		lines = in.readLine().split("\\s+");
		n = Integer.parseInt(lines[0]);
		is = new int[n+1];
		s = Integer.parseInt(lines[1]);
		values = new int[s][];
		
		for( int i = 0; i < s; i++ )
		{
			values[i] = parse(in.readLine());
			for( int j = 0; j < values[i].length; j++ ) is[values[i][j]]++;
		}
		nis = 0;
		mapN = new int[n+1];
		mapI = new int[100];
		for( int i = 1; i <= n; i++ ) 
		{
			if ( is[i] >= 2 ) 
			{
				mapN[i] = nis;
				mapI[nis] = i;
				nis++;
			}
		}
		graph = new int[nis][nis];
		int vs[], c, a, b;
		for( int i = 0; i < s; i++ )
		{
			vs = new int[100];
			c = 0;
			for( int j = 0; j < values[i].length; j++ )
			{
				if ( is[values[i][j]] >= 2 )
				{
					for( int k = 0; k < c; k++ )
					{
						a = mapN[values[i][vs[k]]];
						b = mapN[values[i][j]];
						if ( graph[a][b] != 0 )
						{
							graph[a][b] = Math.min(j - vs[k], graph[a][b]);
							graph[b][a] = Math.min(j - vs[k], graph[b][a]);
						}
						else
						{
							graph[a][b] = j - vs[k];
							graph[b][a] = j - vs[k];
						}
					}
					vs[c++] = j;
				}
			}
		}
		
		int s1, s2;
		for( int i = 0; i < nis; i++ )
		{
			for( int j = 0; j < nis; j++ )
			{
				for( int k = 0; k < nis; k++ )
				{
					s1 = graph[j][i];
					s2 = graph[i][k];
					if ( j != k && s1 != 0 && s2 != 0 && (s1 + s2 < graph[j][k] || graph[j][k] == 0) )
					{
						graph[j][k] = s1+s2;
					}
				}
			}
		}
		int sum = 0;
		int min = Integer.MAX_VALUE, value = -1;
		for( int i = 0; i < nis; i++ )
		{
			sum = 0;
			for( int j = 0; j < nis; j++ )
			{
				if ( j != i) sum += graph[i][j];
			}
			if ( sum < min )
			{
				min = sum;
				value = i;
			}
		}
		out.append("Krochanska is in: "+mapI[value]+"\n");
	}
	System.out.print(out);
}
	public static int[] parse(String line)
	{
		String lines[] = line.split("\\s+");
		int s = lines.length;
		int result[] = new int[s-1];
		for( int i = 0; i < s-1; i++ )
		{
			result[i] = Integer.parseInt(lines[i]);
		}
		return result;
	}
}
