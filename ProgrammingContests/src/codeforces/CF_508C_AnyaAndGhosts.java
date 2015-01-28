package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_508C_AnyaAndGhosts {
public static int[] parseInts(String line) {
	String lines[] = line.split(" ");
	int n = lines.length;
	int r[] = new int[n];
	for (int i = 0; i < n; i++) {
		r[i] = Integer.parseInt(lines[i])+500;
	}
	return r;
}
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("inBad");
	String line, lines[];
	int m, t, r, ws[];
	boolean flags[] = new boolean[1000];
	int count = 0, candlesUp, difference;
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));	
	lines = in.readLine().split("\\s+");	
	m = Integer.parseInt(lines[0]);
	t = Integer.parseInt(lines[1]);
	r = Integer.parseInt(lines[2]);
	ws = parseInts(in.readLine());
	if ( t < r) System.out.println("-1");
	else
	{
		for ( int i = 0; i < m; i++ )
		{
			candlesUp = 0;
			for ( int j = 1; j <= t; j++ ) if ( flags[ws[i]-j] ) candlesUp++;
			if ( candlesUp >= r) continue;
			else
			{
				difference = r - candlesUp;
				for ( int j = 1; j <= difference; j++ ) { flags[ws[i]-j] = true;  count++; }
			}
			
		}
		System.out.println(count);
	}
		
}
}
