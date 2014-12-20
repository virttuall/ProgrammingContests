package Codeforces;


import java.util.*;
import java.io.*;
import java.math.*;
public class CF_106B_ChoosingLaptop {
public static void main(String[] args) throws IOException {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder output = new StringBuilder();
	int n = Integer.parseInt(input.readLine()), arr[][];
	arr = new int[n][4];
	String lines[];
	boolean ds[] = new boolean[n], flag;
	int count;
	for( int i = 0; i < n; i++ )
	{
		lines = input.readLine().split(" ");
		for( int j = 0; j < 4; j++ ) arr[i][j] = Integer.parseInt(lines[j]);
	}
	for( int i = 0; i < n; i++ )
	{
		flag = true;
		for( int j = 0; j <n ; j++ )
		{
			if ( i != j)
			{
				count = 0;
				for( int k = 0; k < 4; k++ )
				{
					if ( arr[i][k] < arr[j][k]) count++;
				}
				if ( count == 4) { ds[i] = true; break; }
			}
		}
	}
	int min = Integer.MAX_VALUE, ii = 0;
	for( int i = 0; i <n; i++ )
	{
		if ( !ds[i])
		{
			if ( arr[i][3] < min ){ min = arr[i][3]; ii = i;}
		}
	}
	System.out.println(ii+1);
	
}
}