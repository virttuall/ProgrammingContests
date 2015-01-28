package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;

public class CF_Goodbye2014_B_NewYearPermutation 
{
	static class Permutation implements Comparable<Permutation>
	{
		int arr[];
		int size;
		@Override
		public int compareTo(Permutation o) {
			// TODO Auto-generated method stub
			for ( int i = 0; i < size; i++ )
			{
				if ( this.arr[i] < o.arr[i] ) return -1;
				else if ( this.arr[i] > o.arr[i] ) return 1;
			}
			return 0;
		}
	    Permutation prototypeWithSwap( int i , int j)
	    {
	    	if ( (i < j && arr[i] > arr[j] ) || ( j < i && arr[i]  < arr[j]))
	    	{
	    		int r[] = new int[size];
		    	for ( int k = 0; k < size; k++ )
		    	{
		    		r[k] = arr[k];
		    	}
		    	r[i] = arr[j];
		    	r[j] = arr[i];
		    	return new Permutation(r);
	    	}
	    	return null;
	    }
	    public Permutation( int arr[])
	    {
	    	this.arr = arr;
	    	size = arr.length;
	    }
	    public String toString()
	    {
	    	String r = arr[0]+"";
	    	for ( int i = 1; i < size; i++)
	    	{
	    		r += " "+arr[i];
	    	}
	    	return r;
	    }
		
	}
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
		int n = Integer.parseInt(in.readLine());
	    Permutation permutation = new Permutation(parseInts(in.readLine())), auxP;
	    int x[] = new int[n*n], y[] = new int[n*n], p = 0;
	    boolean matrix[][] = new boolean[n][n];
	    char arrCharts[];
	    for ( int i = 0; i < n; i++ )
	    {
	    	arrCharts = in.readLine().toCharArray();
	    	for ( int j = 0; j < n; j++ )
	    	{
	    		if ( arrCharts[j] == '1')
	    		{
	    			matrix[i][j] = true;
	    			matrix[j][i] = true;
	    		}
	    	}
	    }
	    for ( int piv = 0; piv < n; piv++ )
	    {
	    	for ( int i = 0; i < n; i++ )
	    	{
	    		for ( int j = 0; j < n; j++ )
	    		{
	    			if ( matrix[i][piv] && matrix[piv][j] )
	    				matrix[i][j] = true;
	    		}
	    	}
	    }
	    for ( int i = 0; i < n; i++ ) for ( int j= i+1; j < n; j++ )
	    	if ( matrix[i][j] )	
	    	{	
	    		x[p] = i;
		    	y[p++] = j;	    		
	    	}
	    boolean flag = true;
	    while(flag)
	    {
	    	flag = false;
	    	for ( int i = 0; i < p; i++ )
	    	{
	    		auxP = permutation.prototypeWithSwap(x[i], y[i]);
	    		if ( auxP != null && auxP.compareTo(permutation) < 0)
	    		{
	    			permutation = auxP;
	    			flag = true;
	    		}
	    	}
	    }
	    System.out.println(permutation.toString());
	}
}
