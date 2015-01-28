package codeforces;

import java.util.*;
import java.io.*;
import java.math.*;
public class CF_75A_LifeWithoutZeros {
public static void main(String[] args) throws IOException {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder output = new StringBuilder();
	String a, b, c;
	a = input.readLine();
	b = input.readLine();
	c = ""+(Integer.parseInt(a) + Integer.parseInt(b));
	a = a.replaceAll("0", "");
	b = b.replaceAll("0", "");
	c = c.replaceAll("0", "");
	if ( Integer.parseInt(a)+Integer.parseInt(b) == Integer.parseInt(c))
		System.out.println("YES");
	else
		System.out.println("NO");
	
}
}