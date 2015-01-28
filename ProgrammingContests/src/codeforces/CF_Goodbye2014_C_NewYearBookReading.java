package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
public class CF_Goodbye2014_C_NewYearBookReading {
	public static int[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(lines[i]);
		}
		return r;
	}
	public static int sum(int i, int arr[], int weight[])
	{
		int sum = 0;
		int j = 0;
		for ( ; arr[j] != i; j++ )
		{
			sum += weight[arr[j]];
		}
		int aux = arr[j];
		for ( int k = j-1; k >= 0; k-- )
			arr[k+1] = arr[k];
		arr[0] = aux;
		return sum;
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
	int n, m;
	lines = in.readLine().split(" ");
	n = Integer.parseInt(lines[0]);
	m = Integer.parseInt(lines[1]);
	int ws[] = parseInts(in.readLine());
	int bs[] = parseInts(in.readLine());
	int stack[] = new int[n], count = 0;
	boolean flags[] = new boolean[n];
	for ( int i = 0; i < m; i++ )
	{
		if ( !flags[bs[i]-1])
		{
			stack[count++] = bs[i]-1;
			flags[bs[i]-1] = true;
		}
	}
	for ( int i = 0; i < n; i++ )
		if ( !flags[i])
			stack[count++] = i;
	int result = 0;
	for ( int i = 0 ; i < m; i++ )
	{
		result += sum( bs[i]-1, stack, ws);
	}
	System.out.println(result);
}
}
