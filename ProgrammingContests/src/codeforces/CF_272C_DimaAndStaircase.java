package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_272C_DimaAndStaircase {
	public static long[] parseLongs(String line) {
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
	int n, k, a, b;
	long arr[], max;
	while ((line = in.readLine()) != null) {
		n = Integer.parseInt(line);
		arr = parseLongs(in.readLine());
		max = arr[0];
		k = Integer.parseInt(in.readLine());
		for ( int i = 0; i<  k; i++ )
		{
			lines = in.readLine().split(" ");
			a = Integer.parseInt(lines[0]);
			b = Integer.parseInt(lines[1]);
			max =Math.max(max, arr[a-1]);
			out.append(max+"\n");
			max += b;
		}
	}
	System.out.print(out);
}
}
