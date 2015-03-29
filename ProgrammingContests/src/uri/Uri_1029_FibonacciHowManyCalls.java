package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1029_FibonacciHowManyCalls {
	public static int[] fib( int f)
	{
		if ( f == 1)
		{
			return new int[]{1, 1};
		}
		if ( f == 0)
		{
			return new int[]{0, 1};
		}
		else
		{
			int v1[] = fib(f-1);
			int v2[] = fib(f-2);
			return new int[]{v1[0]+v2[0], v1[1]+v2[1]+1};
		}
		
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
	int n = Integer.parseInt(in.readLine()), r[], v;
	for ( int i = 0; i<  n; i++ )
	{
		v = Integer.parseInt(in.readLine());
		r = fib(v);
		out.append("fib("+v+") = "+(r[1]-1) + " calls = "+r[0]+"\n");
	}
	System.out.print(out);
}
}
