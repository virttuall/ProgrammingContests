package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_51A_CheateriussProblem {
	static class Pila
	{
		int upleft, upright, downleft, downright;
		public Pila( int a, int b, int c, int d)
		{
			upleft = a;
			upright = b;
			downleft = c;
			downright= d;
		}
		public boolean enc( int a, int b, int c, int d)
		{
			if ( (a == upleft && b == upright && c == downleft && d == downright) )
				return true;
			return false;
		}
		public void set( int a, int b, int c, int d)
		{
				downleft = c;
				downright = d;
				upleft = a;
				upright= b;	
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
	int a, b, c, d;
	ArrayList<Pila> list = new ArrayList<Pila>();
	int n = Integer.parseInt(in.readLine());
	boolean flag;
	int aux;
	for ( int i = 0; i < n; i++ )
	{
		line = in.readLine();
		a = Integer.parseInt(line.substring(0, 1));
		b = Integer.parseInt(line.substring(1, 2));
		line = in.readLine();
		c = Integer.parseInt(line.substring(0, 1));
		d = Integer.parseInt(line.substring(1, 2));
		flag = false;
		c: for ( int j = 0; j < list.size(); j++ )
		{
			for ( int k = 0; k < 4; k++ )
			{
				if ( list.get(j).enc(a, b, c, d))
				{
					list.get(j).set(a, b, c, d);
					flag = true;
					break c;
				}
				aux = a;
				a = c;
				c = d;
				d = b;
				b = aux;
			}
		}
		if (!flag)
		{
			list.add( new Pila(a, b, c, d));
		}
		if ( i!= n-1)
			in.readLine();
	}
	System.out.print(list.size());
}
}
