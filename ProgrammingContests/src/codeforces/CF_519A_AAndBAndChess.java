package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;

public class CF_519A_AAndBAndChess {
	public static void main(String[] args) throws IOException {
		BufferedReader in;
		StringBuilder out = new StringBuilder();
		File file = new File("in");
		if (file.exists())
			in = new BufferedReader(new FileReader(file));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		String line, lines[] = new String[8];
		int a = 0, b = 0;
		for ( int i = 0; i<  8; i++ )
		{
			lines[i] = in.readLine();
			for ( int j = 0; j < 8; j++ )
			{
				line = lines[i].substring(j, j+1);
				if ( line.equals("q"))
				{
					a += 9;
				}
				else if ( line.equals("r"))
				{
					a += 5;
				}
				else if ( line.equals("b"))
				{
					a += 3;
				}
				else if ( line.equals("n"))
				{
					a += 3;
				}
				else if ( line.equals("p"))
				{
					a += 1;
				}
				else if ( line.equals("k"))
				{
					a += 0;
				}
				else if ( line.equals("Q"))
				{
					b += 9;
				}
				else if ( line.equals("R"))
				{
					b += 5;
				}
				else if ( line.equals("B"))
				{
					b += 3;
				}
				else if ( line.equals("N"))
				{
					b += 3;
				}
				else if ( line.equals("P"))
				{
					b += 1;
				}
				else if ( line.equals("K"))
				{
					b += 0;
				}
			}
		}
		if ( a == b)
			System.out.println("Draw");
		else if ( a > b)
			System.out.println("Black");
		else
			System.out.println("White");
	}
}
