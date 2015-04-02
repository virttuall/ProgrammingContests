package TLE_forToPassToCpp;

//TLE
// to pass to c++

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class SPOJ_MultiplesOf3 {
public static int aux, auxl[], auxr[], result[] = new int[3];
static class ST
{
	int nZero, nOne, nTwo, init, finish;
	boolean update;
	ST left, right;
	public ST( int a, int b)
	{
		init = a;
		finish = b;
		nTwo= nOne  = 0;
		nZero = finish - init +1;
		update = false;
		if ( a!= b)
		{
			left = new ST(a, (a+b)/2);
			right =new ST(1+((a+b)/2), b);
		}
	}
	public int[] set( int a , int b)
	{
		
		if ( update )
		{
			aux = nTwo;
			nTwo = nOne;
			nOne = nZero;
			nZero = aux;
			if ( init != finish )
			{
				left.update = true;
				right.update = true;
			}
			update = false;
		}
		if ( init == a && finish == b)
		{
			result[0] = nTwo - nZero;
			result[1] = nZero - nOne;
			result[2] = nOne - nTwo;
			
			if ( a != b)
			{
				left.update = true;
				right.update = true;
			}
			
		}
		else if ( a <= left.finish && b >= right.init )
		{
			auxl =left.set(a, left.finish);
			auxr = right.set(right.init, b);
			result[0] = auxl[0]+auxr[0];
			result[1] = auxl[1]+auxr[1];
			result[2] = auxl[2]+auxr[2];
			
			
		}
		else if ( a <= left.finish )
		{
			result = left.set(a, b);
			
		}
		else
		{
			result = right.set(a, b);
		}
		nZero += result[0];
		nOne += result[1];
		nTwo += result[2];
		return result;
		
	}
	public int query( int a, int b)
	{
		if ( update )
		{
			aux = nTwo;
			nTwo = nOne;
			nOne = nZero;
			nZero = aux;
			if ( init != finish )
			{
				left.update = true;
				right.update = true;
			}
			update = false;
		}
		if ( init == a && finish == b) return nZero;
		if ( a <= left.finish && b >= right.init ) return left.query(a, left.finish) + right.query(right.init, b);
		if ( a <= left.finish ) return left.query(a, b);
		return right.query(a, b);
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
	int n, q, a, b;
	ST root;
	while ((line = in.readLine()) != null) {
		lines = line.split(" ");
		n = Integer.parseInt(lines[0]);
		q = Integer.parseInt(lines[1]);
		root = new ST(1, n);
		for (int i = 0; i < q; i++) {
			lines = in.readLine().split(" ");
			if ( lines[0].equals("0"))
			{
				root.set(Integer.parseInt(lines[1])+1, Integer.parseInt(lines[2])+1);
			}
			else
			{
				out.append(root.query(Integer.parseInt(lines[1])+1, Integer.parseInt(lines[2])+1)+"\n");
			}
		}
	}
	System.out.print(out);
}
}
