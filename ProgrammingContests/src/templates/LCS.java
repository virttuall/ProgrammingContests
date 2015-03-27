package templates;
import java.io.*;
import java.util.*;
import java.math.*;
public class LCS {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	char line1[], line2[];
	line1 = in.readLine().toCharArray();
	line2 = in.readLine().toCharArray();
	int dp[][] = new int[line1.length+1][line2.length+1];
	for ( int i = 0; i <= line1.length; i++ ) dp[i][0] = 0;
	for ( int i = 0; i <= line2.length; i++ ) dp[0][i] = 0;
	for ( int i = 1; i <= line1.length; i++ )
	{
		for ( int j = 1; j <= line2.length; j++ )
		{
			if ( line1[i-1] == line2[j-1]) 
				dp[i][j] = dp[i-1][j-1]+1;
			else dp[i][j] = ( dp[i][j-1] > dp[i-1][j] ) ? dp[i][j-1] : dp[i-1][j];
		}
	}
	int i = line1.length;
	int j = line2.length;
	String result = "";
	while( i != 0 && j != 0 )
	{
		if ( dp[i][j] == dp[i-1][j-1] +1 ) 
		{
			result = line1[i-1] + result;
			i--;
			j--;
		}
		else 
		{
			if ( dp[i-1][j] > dp[i][j-1]) i--;
			else j--;
		}
	}
	System.out.println(dp[line1.length][line2.length]);
	System.out.println(result);
}
}
