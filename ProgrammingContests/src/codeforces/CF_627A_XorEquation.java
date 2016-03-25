import java.io.*;
import java.math.*;
import java.util.*;
public class CF_627_XorEquation {
	public static void main(String[] args) throws IOException {
		File file = new File("in");
		BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		String line, lines[];
		Long s, x;
		lines = in.readLine().split("\\s+");
		s = Long.parseLong(lines[0]);
		x = Long.parseLong(lines[1]);
		String sum = Long.toBinaryString(s);
		String xor = Long.toBinaryString(x);
		long result = 1l;
		int size = Math.max(sum.length(), xor.length());
		while( sum.length() < size ) sum = "0"+sum;
		while( xor.length() < size ) xor = "0"+xor;
		boolean carry = false;
		int v = -1;
		boolean flag = false;
		for( int i = 0; i < size; i++ )
		{
			v = 0;
			if ( carry ) v += 2;
			if ( sum.substring(i, i+1).equals("1")) v++;
			if ( xor.substring(i, i+1).equals("1") )
			{
				if ( v == 0 || v == 3)
				{
					result *= 0l;
					break;
				}
				else if ( v == 1)
				{
					result *= 2l;
					carry = false;
				}
				else
				{
					result *=2l;
					carry = true;
				}
			}
			else
			{
				if ( v%2  == 0 )
				{
					carry = false;
				}
				else
				{
					carry = true;
				}
				if ( v > 1) flag = true;
			}
		}
		if ( carry ) result = 0l;
		if ( result == 0) {System.out.println(result);}
		else
		{
			if ( !flag )
			{
				result = result - 2l;
			}
			System.out.println(result);
		}
	}
}