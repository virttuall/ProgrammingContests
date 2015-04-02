package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_266B_QueueAtTheSchool {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	lines = in.readLine().split(" ");
	int n = Integer.parseInt(lines[0]);
	int s = Integer.parseInt(lines[1]);
	char arr[] = in.readLine().toCharArray();
	char arr1[] = new char[arr.length];
	for ( int i= 0; i<  n; i++ ) arr1[i] = arr[i];
	for ( int j = 0; j <  s; j++ )
	{
		
		for ( int i = 0; i < n; i++ )
		{
			if ( arr[i] == 'B' )
			{
				if ( i +1 < n )
				{
					if ( arr[i+1] == 'G' )
					{
						arr1[i] = 'G';
						arr1[i+1] = 'B';
						i++;
					}
				}
			}
		}
		for ( int i= 0; i<  n; i++ ) arr[i] = arr1[i];
	}
	System.out.print(new String(arr));
}
}
