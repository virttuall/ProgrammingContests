package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_236A_BoyOrGirl {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	line = in.readLine();
	char arr[] = line.toCharArray();
	int a[] = new int['z'-'a'+1];
	for ( int i = 0; i < arr.length; i++ )
	{
		a[arr[i]-'a']++;
	}
	int count = 0;
	for ( int i = 0; i<  a.length; i++ )
	{
		if ( a[i] > 0) count++;
	}
	if ( count % 2 == 0)
	{
		out.append("CHAT WITH HER!\n");
	}
	else
	{
		out.append("IGNORE HIM!\n");
	}
	System.out.print(out);
}
}
