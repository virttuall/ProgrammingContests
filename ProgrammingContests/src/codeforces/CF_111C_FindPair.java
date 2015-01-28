package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
public class CF_111C_FindPair {
	public static long[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		long r[] = new long[n];
		for (int i = 0; i < n; i++) {
			r[i] = Long.parseLong(lines[i]);
		}
		return r;
	}
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	long n;
	int a = 0, b = 0;
	long k;
	lines = in.readLine().split(" ");
	n = Long.parseLong(lines[0]);
	k = Long.parseLong(lines[1]);
	long arr[] = parseInts(in.readLine());
	Arrays.sort(arr);
	int size = arr.length;
	int count = 0;
	long arr2[] = new long[size], arr3[] = new long[size];
	long c = arr[0], total = 0, sum = 1;
	for ( int i = 1; i < size; i++ )
	{
		if ( arr[i] != c)
		{
			arr2[count] = c;
			arr3[count++] = sum;
			total += sum;
			sum = 0;
			c = arr[i];
		}
		sum++;
	}
	arr2[count] = c;
	arr3[count++] = sum;
	total += sum;
	for ( int i = 0; i < count; i++ )
	{
		if ( k - arr3[i]*total > 0)
		{
			k -= arr3[i]*total;
		}
		else
		{
			a = i;
			break;
		}
	}
	for ( int i = 0; i < count; i++ )
	{
		if ( k - arr3[i]*arr3[a] > 0)
		{
			k -= arr3[i]*arr3[a];
		}
		else
		{
			b = i;
			break;
		}
	}
	System.out.println(arr2[a]+" "+arr2[b]);

}
}
