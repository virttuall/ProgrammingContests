package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_266A_StonesontheTable {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(input.readLine());
	int count = 0;
	String line = input.readLine();
	String rr = "RR", gg = "GG", bb = "BB";
	int aux;
	for( int t = 0; t < 10; t++)
	{
	boolean flag1 = true,flag2 = true,flag3 = true;
	while(flag1 || flag2 || flag3)
	{
		if ( line.contains(rr) ){ line = line.replaceFirst("RR", "R");count++;}
		else flag1 = false;
		if ( line.contains(gg)) {line = line.replaceFirst("GG","G");count++;}
		else flag2 = false;
		if( line.contains(bb) ) {line = line.replaceFirst("BB", "B");count++;}
		else flag3 = false;
	}
	}
	System.out.println(count);
	
}
}