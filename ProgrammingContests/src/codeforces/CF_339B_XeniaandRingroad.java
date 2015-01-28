package codeforces;

import java.util.*;
import java.io.*;
import java.math.*;

public class CF_339B_XeniaandRingroad {
public static int distancia( int n, int estoy, int voy)
{
	if ( voy < estoy)
	{
		return (n - estoy + voy);
	}
	else
	{
		return voy - estoy;
	}
	
}
public static void main(String[] args) throws IOException{
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	String lines[];
	int n, m;
	long sum = 0;
	int estoy = 1, arr[];
	lines = input.readLine().split(" ");
	n = Integer.parseInt(lines[0]);
	m = Integer.parseInt(lines[1]);
	lines = input.readLine().split(" ");
	arr = new int[lines.length];
	for( int i = 0; i < lines.length; i++ )
	{
		arr[i] = Integer.parseInt(lines[i]);
	}
	
	for( int i = 0; i < m; i++ )
	{
		sum += distancia(n,estoy,arr[i]);
		estoy = arr[i];
	}
	System.out.println(sum);
	
}
}