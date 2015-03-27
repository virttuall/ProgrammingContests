package templates;

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class SparseTableAlgorithm {
public static int arr[] = new int[]{2, 4, 3, 1, 6, 7, 8, 9, 1, 7};
public static int dp[][];
public static void buildSparseTable()
{
	int w = arr.length;
	double lg = Math.log(w)/Math.log(2.0);
	int h = (int)lg +1;
	dp = new int[h][w];
	int a, b;
	for ( int i = 0; i  < w; i++ )
	{
		dp[0][i] = i;
	}
	for ( int j = 1; j < h; j++ )
	{
		for( int i = 0; i< w; i++ )
		{
			if ( i + (1<<(j-1)) >= w)
			{
				dp[j][i] = -1;
			}
			else
			{
				a = dp[j-1][i];
				b = dp[j-1][i + (1<<(j-1)) ];
				if ( b == -1) dp[j][i] = -1;
				else dp[j][i] =  ( arr[a] < arr[b] ) ? a : b;
			}
		}
	}
}
public static int query(int a, int b)
{
	int  size = b-a+1, v, v1, v2;
	double aux = Math.log( size) / Math.log(2);
	v = (int)aux;
	v1 = dp[v][a];
	if ( size > 1<<v)
	{
		v2 = query(a+1<<v, b);
		if ( arr[v1] < arr[v2]) return v1;
		else return v2;
	}
	else
	{
		return v1;
	}
}
public static void main(String[] args) {
	
	buildSparseTable();
	for( int i = 0; i< dp.length; i++) System.out.println(Arrays.toString(dp[i]));
	System.out.println(arr[query(4,7)]);
	System.out.println(arr[query(1,1)]);
	System.out.println(arr[query(2,2)]);
	System.out.println(arr[query(3,3)]);
	
	
}
}
