package codeforces;


import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;
public class CF_6A_Triangle {
public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String lines[];
	StringBuilder out = new StringBuilder();
	lines = in.readLine().split(" ");
	int a1, a2, a3, a4, t1, t2, t3;
	a1 = Integer.parseInt(lines[0]);
	a2 = Integer.parseInt(lines[1]);
	a3 = Integer.parseInt(lines[2]);
	a4 = Integer.parseInt(lines[3]);
	
	t1 = a1; t2 = a2; t3 = a3;
	if ( t1 + t2 > t3 && t1 + t3 > t2 && t3 + t2 > t1 ) 
	{
		System.out.println("TRIANGLE");
		return;
	}
	t1 = a1; t2 = a2; t3 = a4;
	if ( t1 + t2 > t3 && t1 + t3 > t2 && t3 + t2 > t1 ) 
	{
		System.out.println("TRIANGLE");
		return;
	}
	t1 = a1; t2 = a3; t3 = a4;
	if ( t1 + t2 > t3 && t1 + t3 > t2 && t3 + t2 > t1 ) 
	{
		System.out.println("TRIANGLE");
		return;
	}
	t1 = a2; t2 = a3; t3 = a4;
	if ( t1 + t2 > t3 && t1 + t3 > t2 && t3 + t2 > t1 ) 
	{
		System.out.println("TRIANGLE");
		return;
	}
	
	
	t1 = a1; t2 = a2; t3 = a3;
	if ( t1 + t2 == t3 || t1 + t3 == t2 || t3 + t2 == t1 ) 
	{
		System.out.println("SEGMENT");
		return;
	}
	t1 = a1; t2 = a2; t3 = a4;
	if ( t1 + t2 == t3 || t1 + t3 == t2 || t3 + t2 == t1 ) 
	{
		System.out.println("SEGMENT");
		return;
	}
	t1 = a1; t2 = a3; t3 = a4;
	if ( t1 + t2 == t3 || t1 + t3 == t2 || t3 + t2 == t1 ) 
	{
		System.out.println("SEGMENT");
		return;
	}
	t1 = a2; t2 = a3; t3 = a4;
	if ( t1 + t2 == t3 || t1 + t3 == t2 || t3 + t2 == t1 ) 
	{
		System.out.println("SEGMENT");
		return;
	}
	System.out.println("IMPOSSIBLE");
}
}