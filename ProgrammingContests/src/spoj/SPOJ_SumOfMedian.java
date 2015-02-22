package spoj;
import java.io.*;
import java.util.*;
import java.math.*;
public class SPOJ_SumOfMedian {
public static int[] parseInts(String line) {
	String lines[] = line.split(" ");
	int n = lines.length;
	int r[] = new int[n];
	for (int i = 0; i < n; i++) {
		r[i] = Integer.parseInt(lines[i]);
	}
	return r;
}
public static int[] sort( int[] a, int[] b)
{
	int i = 0, j = 0, l = a.length;
	int result[] = new int[l*2];
	for ( ; i < l && j < l; )
	{
		if ( a[i] < b[j])
		{
			result[i+j] = a[i];
			i++;
		}
		else
		{
			result[i+j] = b[j];
			j++;
		}
	}
	for ( ; i < l; i++) result[i+j] = a[i];
	for ( ; j < l; j++) result[i+j] = b[j];
	return result;
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
	lines = in.readLine().split(" ");
	int n, l, matrix[][], aux[], sum = 0;
	n = Integer.parseInt(lines[0]);
	l = Integer.parseInt(lines[1]);
	matrix = new int[n][l];
	aux = new int[2*l];
	for ( int i = 0; i < n; i++ ) matrix[i] = parseInts(in.readLine());
	for ( int i = 0; i < n; i++ )
	{
		for ( int j = i+1; j < n; j++ )
		{
			aux = sort( matrix[i], matrix[j]);
			sum = (sum + aux[l-1]) %1000000000; 
		}
	}
	System.out.print(sum);
}
}
