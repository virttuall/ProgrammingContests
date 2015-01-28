package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
public class CF_270C_DesignTutorial_MakeItNondeterministic {
	public static int[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(lines[i]) - 1;
		}
		return r;
	}
	public static String minString(String a, String b)
	{
		if ( a.compareTo(b) < 0) return a;
		return b;
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
	String handles[][] = new String[n][2];
	for ( int i = 0; i < n; i++ )
	{
		lines = in.readLine().split(" ");
		handles[i][0] = lines[0];
		handles[i][1] = lines[1];
	}
	int arr[] = parseInts(in.readLine());
	boolean flag = true, flag1, flag2;
	String min = minString(handles[arr[0]][0], handles[arr[0]][1]);
	for ( int i = 1; i < n; i++ )
	{
		flag1 = min.compareTo(handles[arr[i]][0]) < 0;
		flag2 = min.compareTo(handles[arr[i]][1]) < 0;
		if ( flag1 && flag2)
		{
			min = minString(handles[arr[i]][0],handles[arr[i]][1] );
		}
		else if ( flag1)
		{
			min = handles[arr[i]][0];
		}
		else if ( flag2 )
		{
			min = handles[arr[i]][1];
		}
		else
		{
			flag = false;
			break;
		}
	}
	if ( flag )
		System.out.print("YES");
	else
		System.out.println("NO");
}
}
