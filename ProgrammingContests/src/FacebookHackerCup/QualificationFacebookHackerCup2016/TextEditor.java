import java.io.*;
import java.util.*;
public class TextEditor {
	public static int graph[][], dp[][][], N, arr[];
public static void main(String[] args) throws IOException {
	File file = new File("text_editor.txt");
	BufferedReader in = new BufferedReader( file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	PrintWriter print = new PrintWriter("salida4.txt");
	int T, K, result, lcp[], min, v;
	String lines[], line, words[];
	T = Integer.parseInt(in.readLine());
	for( int t = 0; t < T; t++ )
	{
		result = 0;
		lines = in.readLine().split("\\s+");
		N = Integer.parseInt(lines[0]);
		K = Integer.parseInt(lines[1]);
		words = new String[N+1];
		words[0] = "";
		for( int i= 1; i <= N; i++ )
		{
			words[i] = in.readLine();
		}
		Arrays.sort(words);
		lcp = new int[N+1];
		for( int i = 1; i <= N; i++ )
		{
			lcp[i] = lcp(words[i], words[i-1]);
		}
		graph = new int[N+1][N+1];
		for( int i = 0; i <= N; i++ )
		{
			min = Integer.MAX_VALUE;
			for( int j = i+1; j <= N; j++ )
			{
				min = min(min, lcp[j]);
				v = words[i].length()+words[j].length()-(2*min);
				graph[i][j] = v;
				graph[j][i] = v;
			}
		}
//		System.out.println(Arrays.toString(words));
//		for( int i = 0; i <= N; i++ )
//		{
//			for( int j = 0; j <= N; j++ )
//			{
//				System.out.print(graph[i][j]+" ");
//			}
//			System.out.println();
//		}
		dp = new int[N+1][N+1][N+1];
		arr = new int[N+1];
		arr[N] = words[N].length();
		for( int i = N-1; i >= 0; i--)
		{
			arr[i] = arr[i+1] + graph[i][i+1];
		}
		result = dp(1, K, 0) + K ;
		print.println("Case #"+(t+1)+": "+result);
		System.out.println("Case #"+(t+1)+": "+result);
	}
	
	print.close();
}
public static int dp(int s, int n, int u)
{
	if ( dp[s][n][u] != 0) return dp[s][n][u];
	int result;
	if ( n == 0)
	{
		result = graph[0][u];
	}
	else if ( N - s - n == -1 )
	{
		result = arr[s] + graph[s][u];
	}
	else
	{
	 result = min( dp(s+1, n, u), dp(s+1, n-1, s) + graph[s][u]);
	}
	dp[s][n][u] = result;
	return result;
}
public static int min(int a, int b)
{
	if ( a < b) return a;
	return b;
}
public static int lcp( String a, String b)
{
	char[] as = a.toCharArray();
	char[] bs = b.toCharArray();
	int min = min(as.length, bs.length);
	for(int i = 0; i < min; i++ )
	{
		if ( as[i] != bs[i] ) return i;
	}
	return min;
}
}
