package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
public class CF_525B_PashaAndString {
	public static int[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(lines[i]);
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
	char c[] = in.readLine().toCharArray();
	int sum[] = new int[c.length+1];
	in.readLine();
	int s[] = parseInts(in.readLine()), n, aux;
	Arrays.sort(s);
	char v;
	for ( int i = 0; i < s.length; i++ )
	{
		aux = s[i]-1;
		sum[aux]++;
		sum[c.length- aux]--;
	}
	aux = 0;
	for ( int i = 0; i < sum.length ; i++ )
	{
		aux += sum[i];
		sum[i] = aux;
	}
	for ( int i = 0; i <  c.length/2; i++ )
	{
		if ( sum[i] % 2 == 1)
		{
			v = c[i];
			c[i] = c[c.length-i-1];
			c[c.length-i-1] = v;
		}
	}
	System.out.println(new String(c));
}
}
