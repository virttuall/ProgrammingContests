package Codeforces;


import java.util.*;
import java.io.*;
import java.math.*;

public class CF_339A_HelpfulMaths {
public static void main(String[] args) throws IOException{
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	String line[];
	int[] arr;
	line = input.readLine().split("\\+");
	String r = "";
	arr = new int[line.length];
	for( int i = 0; i < line.length; i++ )
	{
		arr[i] = Integer.parseInt(line[i]);
	}
	Arrays.sort(arr);
	for( int i = 0; i < arr.length; i++ )
	{
		r += arr[i];
		if ( i != arr.length-1)
		r += "+";
	}
	System.out.println(r);
		
}
}