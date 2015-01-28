package codeforces;

import java.math.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.*;
public class CF_90B_AfricanCrossword {
public static void main(String[] args) throws IOException {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder output = new StringBuilder();
	String lines[];
	lines = input.readLine().split(" ");
	int n = Integer.parseInt(lines[0]), m = Integer.parseInt(lines[1]);
    char[][] matrix = new char[n][m];
    boolean[][] matrix2 = new boolean[n][m];
	for( int i = 0; i < n; i++ ) matrix[i] = input.readLine().toCharArray();
	boolean flag = true;
	for( int i = 0; i < n; i++ )
	{
		for( int j = 0; j < m; j++ )
		{
			flag = true;
			for( int row = 0; row < n; row++ )
			{
				if ( i != row )
				{
					if ( matrix[i][j] == matrix[row][j] ){ flag = false; matrix2[row][j] = true;}
				}
			}
			for( int column = 0; column < m; column++ )
			{
				if ( j != column )
				{
					if  ( matrix[i][j] == matrix[i][column] ){ flag = false; matrix2[i][column] = true; }
				}
			}
			if ( !flag ) matrix2[i][j] = true;
		}
	}
	String r = "";
	for( int i = 0; i < n; i++ ) for( int j = 0; j < m; j++ ) if ( !matrix2[i][j] ) r+=matrix[i][j];
	System.out.println(r);
		
	
}
}