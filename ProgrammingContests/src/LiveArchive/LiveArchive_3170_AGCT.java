package LiveArchive;

import java.util.*;
import java.io.*;
public class LiveArchive_3170_AGCT {
public static int min( int x , int y)
{
	if ( x < y )
		return x;
	return y;
}
public static void main(String[] args) throws IOException {
	BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
	StringBuilder output = new StringBuilder();
	String line, lines[];
	char[] cad1, cad2;
	int n1, n2, dp[][] = new int[5001][5001], aux = 0;
	for( int i = 0; i < 5001; i++ ) dp[0][i] = dp[i][0] = i;
	while( (line = input.readLine()) != null && !line.equals(""))
	{
		lines = line.split(" ");
		n1 = Integer.parseInt(lines[0]);
		cad1 = lines[1].toCharArray();
		lines = input.readLine().split(" ");
		n2 = Integer.parseInt(lines[0]); 
		cad2 = lines[1].toCharArray();
		for( int i = 1; i <= n1; i++ )
		{
			for( int j = 1; j <= n2; j++)
			{
				if ( cad1[i-1] != cad2[j-1] ) aux = 1;
				else aux = 0;
				dp[i][j] = min(aux+dp[i-1][j-1],min( dp[i-1][j] + 1, dp[i][j-1]+1));
			}
		}
		output.append(dp[n1][n2]+"\n");
	}
	System.out.print(output);
}
}
