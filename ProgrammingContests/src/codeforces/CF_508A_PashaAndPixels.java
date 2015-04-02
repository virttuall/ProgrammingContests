package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_508A_PashaAndPixels {
public static boolean matrix[][];
public static boolean rev( int i, int j)
{
	try
	{
	if ( matrix[i][j] && matrix[i][j+1] && matrix[i+1][j] && matrix[i+1][j+1]) return true;
	}catch(Exception e){}
	return false;
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
	int n, m, k;
	lines = in.readLine().split(" ");
	n = Integer.parseInt(lines[0]);
	m = Integer.parseInt(lines[1]);
	k = Integer.parseInt(lines[2]);
	int x, y;
	matrix = new boolean[n+1][m+1];
	int r = 0;
	for (int i = 0; i < k; i++) {
		lines = in.readLine().split(" ");
		x = Integer.parseInt(lines[0]);
		y = Integer.parseInt(lines[1]);
		matrix[x][y] = true;
		if ( rev(x, y) || rev(x, y-1) || rev(x-1, y) || rev(x-1, y-1) ) 
		{
			r = i+1;
			break;
		}
	}
	out.append(r+"\n");
	System.out.print(out);
}
}
