import java.io.*;
import java.math.*;
import java.util.*;
public class CF_649C_EduringExodus {
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
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	int n, k;
	lines = in.readLine().split("\\s+");
	n = Integer.parseInt(lines[0]);
	k = Integer.parseInt(lines[1]);
	line = in.readLine();
	int a, b, p;
	int arr[] = new int[n];
	int v = 0;
	for( int i = 0; i < line.length(); i++ )
	{
		if ( line.charAt(i) == '0' )
		{
			arr[v++] = i;
		}
	}
	p = 0;
	int min = Integer.MAX_VALUE;
	for( int i = 0; i < v - k; i++ )
	{
		a = i;
		b = i + k;
		while( p < b && max(arr[p]- arr[a], arr[b] - arr[p]) > max(arr[p+1]- arr[a], arr[b] - arr[p+1]) ) p++;
		min = min( min, max(arr[p]- arr[a], arr[b] - arr[p]));
	}
	System.out.println(min);
}
}
