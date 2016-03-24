import java.io.*;
import java.math.*;
import java.util.*;

public class CF_574D_BearAndBlocks
{
	public static int min( int a, int b)
	{
		if ( a < b ) return a;
		return b;
	}
	public static int max( int a, int b)
	{
		if ( a > b ) return a;
		return b;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String lines[], line;
		int n = Integer.parseInt(in.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		lines = in.readLine().split(" ");
		for ( int i = 0; i < n; i++ )
		{
			arr[i] = Integer.parseInt(lines[i]);
		}
		dp[0] = 1;
		dp[n-1] = 1;
		for( int i = 1; i < n-1; i++ )
		{
			dp[i] = min(arr[i], 1+dp[i-1] );
		}
		int max = Integer.MIN_VALUE;
		for( int i = n-2; i >= 1; i-- )
		{
			dp[i] = min(dp[i], 1+dp[i+1] );
			
		}
		for( int i = 0; i < n; i++ )
		{
			max = max(dp[i], max);
		}
		System.out.println(max);
	}
}
