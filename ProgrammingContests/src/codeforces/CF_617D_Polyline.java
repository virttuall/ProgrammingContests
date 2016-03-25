import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
public class CF_617D_Polyline {
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	long x1, x2, x3, y1, y2, y3;
	lines = in.readLine().split("\\s+");
	x1 = Long.parseLong(lines[0]);
	y1 = Long.parseLong(lines[1]);
	lines = in.readLine().split("\\s+");
	x2 = Long.parseLong(lines[0]);
	y2 = Long.parseLong(lines[1]);
	lines = in.readLine().split("\\s+");
	x3 = Long.parseLong(lines[0]);
	y3 = Long.parseLong(lines[1]);
	long min = 3;
	if ( x1 == x2 && x1 == x3 )
	{
		min = min(min, 1);
	}
	if ( y1 == y2 && y1 == y3)
	{
		min = min(min, 1);
	}
	if ( (x1 == x2 && f(y1,y2,y3)) || (y1 == y2 && f(x1, x2, x3)) )
	{
		min = min(min, 2);
	}
	if ( (x1 == x3 && f(y1, y3, y2)) || (y1 == y3 && f(x1, x3, x2)))
	{
		min = min(min, 2);
	}
	if ( (x3 == x2 && f(y3, y2, y1)) || (y3 == y2 && f(x3, x2, x1)))
	{
		min = min(min, 2);
	}
	System.out.println(min);
}
public static boolean f(long a, long b, long c)
{
	long min = min(a, b);
	long max = max(a, b);
	if ( c > min && c < max) return false;
	return true;
}
public static long min(long a, long b)
{
	if ( a < b) return a;
	return b;
}
public static long max(long a, long b)
{
	if ( a > b) return a;
	return b;
}
}