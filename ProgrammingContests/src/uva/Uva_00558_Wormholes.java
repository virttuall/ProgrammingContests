import java.io.*;
import java.math.*;
import java.util.*;

public class Uva_00558_Wormholes
{
	public static int min(int a, int b)
	{
		if ( a < b) return a;
		return b;
	}
	public static void main(String[] args)	throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		int nCases = Integer.parseInt(in.readLine());
		int n, m, a, b, s, neiV, neiS, sizes[], inf = 10000000;
		String line, lines[];
		List<Integer> graphN[], graphS[];
		boolean flag;
		for( int nC = 0; nC < nCases; nC++ )
		{
			lines = in.readLine().split(" ");
			n = Integer.parseInt(lines[0]);
			m = Integer.parseInt(lines[1]);
			graphN = new List[n];
			graphS = new List[n];
			sizes = new int[n];
			for( int i = 0; i < n; i++ ) 
			{
				graphS[i] = new ArrayList<Integer>();
				graphN[i] = new ArrayList<Integer>();
				sizes[i] = inf;
			}
			sizes[0] = 0;
			for( int i = 0; i < m; i++ )
			{
				lines = in.readLine().split(" ");
				a = Integer.parseInt(lines[0]);
				b = Integer.parseInt(lines[1]);
				s = Integer.parseInt(lines[2]);
				graphN[a].add(b);
				graphS[a].add(s);
			}
			for( int i = 0; i < n-1; i++ )
			{
				for( int j = 0; j < n; j++ )
				{
					for( int k = 0; k < graphN[j].size(); k++)
					{
						neiV = graphN[j].get(k);
						neiS = graphS[j].get(k);
						sizes[neiV] = min(sizes[neiV], sizes[j] + neiS);
					}
				}
			}
			flag = true;
			for( int j = 0; j < n; j++ )
			{
				for( int k = 0; k < graphN[j].size(); k++)
				{
					neiV = graphN[j].get(k);
					neiS = graphS[j].get(k);
					if ( sizes[neiV] > sizes[j] + neiS) flag = false;
				}
			}
			if ( !flag ) out.append("possible\n");
			else out.append("not possible\n");
		}
		System.out.print(out);

	}
}