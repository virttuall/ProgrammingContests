import java.io.*;
import java.math.*;
import java.util.*;
public class CF_624C_GraphAndString {
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	int n, m;
	lines = in.readLine().split("\\s+");
	n = Integer.parseInt(lines[0]);
	m = Integer.parseInt(lines[1]);
	int a, b;
	boolean graph[][] = new boolean[n+1][n+1];
	for( int i = 0; i < m; i++ )
	{
		lines = in.readLine().split("\\s+");
		a = Integer.parseInt(lines[0]);
		b = Integer.parseInt(lines[1]);
		graph[a][b] = true;
		graph[b][a] = true;
	}
	boolean flagN = false;
	char[] values = new char[n+1];
	for(int i = 0; i < values.length; i++ ) values[i] = 'z';
	A: for( int i = 1; i <= n; i++ )
	{
		for( int j = i+1; j <= n; j++ )
		{
			if ( !graph[i][j] )
			{
				if ( values[i] == 'z' && values[j] == 'z' )
				{
					values[i] = 'a'; values[j] = 'c';
				}
				else if ( values[i] == 'z' && values[j] == 'a' )
				{
					values[i] = 'c';
				}
				else if ( values[i] == 'z' && values[j] == 'c' )
				{
					values[i] = 'a';
				}
				else if ( values[j] == 'z' && values[i] == 'a' )
				{
					values[j] = 'c';
				}
				else if ( values[j] == 'z' && values[i] == 'c' )
				{
					values[j] = 'a';
				}
				else if (values[i] == 'a' && values[j] == 'c')
				{
					
				}
				else if (values[i] == 'c' && values[j] == 'a')
				{
					
				}
				else
				{
					flagN = true;
					break A;	
				}
			}
		}
	}
	if ( !flagN)
	{
		B: for( int i = 1; i <= n; i++ )
		{
			for( int j = i+1; j <= n; j++ )
			{
				if ( graph[i][j])
				{
					if ( values[i] == 'a' && values[j] == 'c' )
					{
						flagN = true;
						break B;
					}
					else if ( values[i] == 'c' && values[j] == 'a' )
					{
						flagN = true;
						break B;
					}
					else if ( values[i] == 'z' && values[j] == 'z' )
					{
						values[i] = 'b';
						values[j] = 'b';
					}
					else if ( values[i] == 'z')
					{
						values[i] = 'b';
					}
					else if ( values[j] == 'z' )
					{
						values[j] = 'b';
					}
				}
			}
		}
	}
	if ( flagN )
	{
		System.out.println("No");
	}
	else
	{

		System.out.println("Yes");
		if ( n == 1 ) System.out.println("a");
		else System.out.println(new String(values).substring(1));
	}
}
}