package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
public class CF_525A_VitaliyAndPie {
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
	char l[] = in.readLine().toCharArray();
	int keys[] = new int['z'-'a'+1];
	int count = 0;
	for ( int i = 0; i<  (n-1)*2; i=i+2 )
	{
		keys[l[i]-'a']++;
		if ( keys[l[i+1]-'A'] > 0 ) 
		{
			keys[l[i+1]-'A']--;
		}
		else
		{
			count++;
		}
	}
	System.out.println(count);
}
}
