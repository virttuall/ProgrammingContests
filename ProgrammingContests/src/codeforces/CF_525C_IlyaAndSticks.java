package codeforces;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class CF_525C_IlyaAndSticks {
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
	int n  = Integer.parseInt(in.readLine());
	int arr[] = parseInts(in.readLine());
	int num[] = new int[1000001];
	boolean r[] = new boolean[1000001];
	for ( int i= 0; i< n; i++ ) num[arr[i]]++;
	for( int i = 1000000; i >= 1; i-- )
	{
		if( num[i] != 0 )
		{
			if ( num[i] % 2 == 1)
			{
				if ( !(r[i] && num[i] == 1))
				{
					num[i]--;
					num[i-1]++;
					r[i-1] = true;
				}
			}
		}
	}
	int i = 1000000;
	long area = 0;
	int a, b;
	while( i > 0)
	{
		try
		{
		while ( num[i] <= 1) i--;
		num[i]-=2;
		a = i;
		while ( num[i] <= 1) i--;
		num[i]-=2;
		b = i;
		area += (long)a*(long)b;
		}catch(Exception e){}
	}
	System.out.println(area);
}
}
