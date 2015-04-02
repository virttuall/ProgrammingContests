package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_441B_ValeraAndFruits {
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
	int n = Integer.parseInt(lines[0]);
	int v = Integer.parseInt(lines[1]);
	int arr[] = new int[3003];
	int arr1[] = new int[3003];
	for ( int i = 0; i < n; i++ )
	{
		lines = in.readLine().split(" ");
		arr[Integer.parseInt(lines[0])] += Integer.parseInt(lines[1]); 
	}
	int count = 0;
	int c;
	for ( int i = 1; i <= 3001; i++ )
	{
		c = 0;
		if ( arr1[i] > 0 )
		{
			c = Math.min( v, arr1[i] );
			count += c;
		}
		c = v - c;
		c = Math.min(c, arr[i]);
		count += c;
		arr1[i+1] = Math.max(arr[i]-c, 0);
	}
	System.out.println(count);
}
}
