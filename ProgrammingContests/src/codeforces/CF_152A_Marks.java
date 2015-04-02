package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_152A_Marks {
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
	int m = Integer.parseInt(lines[1]);
	int matrix[][] = new int[n][m];
	int max;
	boolean suc[] = new boolean[n];
	for ( int i = 0; i < n; i++ )
	{
		line = in.readLine();
		for ( int j = 0; j < m; j++ )
		{
			matrix[i][j] = Integer.parseInt(line.substring(j, j+1));
		}

		
	}
	for ( int j = 0; j < m; j++ )
	{
		max = Integer.MIN_VALUE;
		for ( int i = 0; i < n; i++ )
		{
			if ( matrix[i][j] > max ) max = matrix[i][j];
		}
		for ( int i = 0; i < n; i++ )
		{
			if ( matrix[i][j] == max ) suc[i] = true;
		}
	}
	int count = 0;
	for ( int i = 0; i<  n; i++ )
		if ( suc[i] ) count++;
	out.append(count+"\n");
	System.out.print(out);
}
}
