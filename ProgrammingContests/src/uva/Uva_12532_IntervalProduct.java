package uva;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uva_12532_IntervalProduct {
	public static int arr[];
	static class ST
	{
		int value, init, finish;
		ST left, right;
		public ST( int i, int f)
		{
			init = i;
			finish = f;
			if ( i != f)
			{
				left = new ST(i, (i+f)/2);
				right = new ST(1+((i+f)/2), f);
				value = left.value*right.value;
			}
			else
			{
				value = arr[i];
			}
		}
		public int set( int index, int v)
		{
			int result = 1;
			if ( init == finish )
			{
				result = v;
				value = v;
			}
			else if ( index <= left.finish )
			{
				result = left.set(index, v)*right.value;
				value = result;
			}
			else
			{
				result = right.set(index, v)*left.value;
				value = result;
			}
			return result;
		}
		public int query(int a, int b)
		{
			if ( init == a && finish == b )
			{
				return value;
			}
			if(a <= left.finish && b >= right.init)
			{
				return left.query(a, left.finish)*right.query(right.init, b);
			}
			if ( a <= left.finish )
			{
				return left.query(a,b);
			}
			return right.query(a,b);
		}
	}
	
	public static int[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		int r[] = new int[n+1], aux;
		for (int i = 0; i < n; i++) {
			aux = Integer.parseInt(lines[i]);
			if ( aux > 0)
			{
				r[i+1] = 1;
			}
			else if ( aux < 0)
			{
				r[i+1] = -1;
			}
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
	String line, lines[], s;
	int n, q, r, aux;
	ST root;
	while ((line = in.readLine()) != null) {
		lines = line.split(" ");
		n = Integer.parseInt(lines[0]);
		q = Integer.parseInt(lines[1]);
		arr = parseInts(in.readLine());
		root = new ST(1, n);
		for ( int i = 0; i < q; i++ )
		{
			lines = in.readLine().split(" ");
			if (lines[0].equals("C"))
			{
				aux = Integer.parseInt(lines[2]);
				if ( aux > 0) aux = 1;
				if ( aux < 0 ) aux = -1;
				root.set(Integer.parseInt(lines[1]), aux);
			}
			else
			{
				r = root.query(Integer.parseInt(lines[1]), Integer.parseInt(lines[2]));
				s = "0";
				if ( r == 1) s = "+";
				else if (r == -1) s = "-";
				out.append(s);
			}
		}
		out.append("\n");
	}
	System.out.print(out);
}
}
