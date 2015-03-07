package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;

public class CF_519B_AAndBAndCompilationErrors {
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
	int n = Integer.parseInt(in.readLine());
	int arr1[] = parseInts(in.readLine());
	int arr2[] = parseInts(in.readLine());
	int arr3[] = parseInts(in.readLine());
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	Arrays.sort(arr3);
	boolean flaga = true, flagb = true;
	int i = 0, a = 0, b = 0;
	for ( ; i < n-1; i++ )
	{
		if ( arr2[i] != arr1[i])
		{
			a = arr1[i];
			flaga = false;
			break;
		}
	}
	if ( flaga) { a = arr1[n-1]; }
	i = 0;
	for ( ; i < n-2; i++ )
	{
		if ( arr3[i] != arr2[i])
		{
			b = arr2[i];
			flagb = false;
			break;
		}
	}
	if ( flagb) b = arr2[n-2];
	System.out.println(a);
	System.out.println(b);
}
}
