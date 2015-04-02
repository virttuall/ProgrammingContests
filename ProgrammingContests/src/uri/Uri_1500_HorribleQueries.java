package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1500_HorribleQueries {
static class STLP
{
	int init, finish;
	long value, update, length;
	STLP left, right;
	public STLP( int i, int f)
	{
		init = i;
		finish = f;
		value = 0;
		update = 0;
		length = finish-init+1;
		if ( i != f)
		{
			left = new STLP(i, (i+f)/2);
			right = new STLP(1+((i+f)/2), f);
		}
	}
	public void upd()
	{
		value += update*length;
		if ( init != finish )
		{
			left.update += update;
			right.update += update;
		}
		update = 0;
	}
	public long set( int a, int b, long v)
	{
		long result = 0;
		if ( update != 0 )
		{
			upd();
		}
		if ( a == init && b == finish )
		{
			value += v*length;
			if (init != finish)
			{
				left.update += v;
				right.update += v;
			}
			result = v*length;
		}
		else if( left.init <= a && left.finish >= b)
		{
			result = left.set(a, b, v);
			value += result;
		}
		else if( right.init <= a && right.finish >= b)
		{
			result = right.set(a, b, v);
			value += result;
		}
		else
		{
			result = left.set(a,left.finish,v) + right.set(right.init,b,v);
			value += result;
		}
		return result;
	}
	public long query( int a, int b)
	{
		long result = 0;
		if ( update != 0 )
		{
			upd();
		}
		if ( a == init && b == finish )
		{
			result = value;
		}
		else if( left.init <= a && left.finish >= b)
		{
			result = left.query(a, b);
		}
		else if( right.init <= a && right.finish >= b)
		{
			result = right.query(a, b);
		}
		else
		{
			result = left.query(a,left.finish) + right.query(right.init,b);
		}
		return result;
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
	int n, c, p, q, t;
	long v;
	t = Integer.parseInt(in.readLine());
	STLP root;
	for ( int tt = 0; tt < t; tt++ )
	{
		lines = in.readLine().split(" ");
		n = Integer.parseInt(lines[0]);
		c = Integer.parseInt(lines[1]);
		root = new STLP(1, n);
		for ( int i = 0; i < c; i++ )
		{
			lines = in.readLine().split(" ");
			if ( lines[0].equals("0"))
			{
				root.value += root.set(Integer.parseInt(lines[1]), Integer.parseInt(lines[2]), Long.parseLong(lines[3]));
			}
			else
			{
				out.append(root.query(Integer.parseInt(lines[1]), Integer.parseInt(lines[2]))+"\n");
			}
		}
	}
	System.out.print(out);
}
}
