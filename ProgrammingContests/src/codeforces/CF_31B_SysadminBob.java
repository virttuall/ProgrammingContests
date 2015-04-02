package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_31B_SysadminBob {
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
	String r = "";
	ArrayList<String> list = new ArrayList<String>();
	boolean flag = false;
	if ( !line.contains("@") )
	{
		System.out.println("No solution");
	}
	else if ( line.contains("@@"))
	{
		System.out.println("No solution");
	}
	else if ( line.endsWith("@") || line.startsWith("@"))
	{
		System.out.println("No solution");
	}
	else
	{
		lines = line.split("@");
		for ( int i = 1; i < lines.length-1; i++)
		{
			if (lines[i].length()== 1) {flag = true; break;}
			else
			{
				list.add(lines[i].substring(0, 1));
				list.add(lines[i].substring(1));
			}
		}
		if ( flag)
		{
			System.out.println("No solution");
		}
		else
		{
			if ( list.size() == 0)
			{
				 System.out.println(line);
			}
			else if ( list.size() == 2)
			{
				System.out.println(lines[0]+"@"+list.get(0)+","+list.get(1)+"@"+lines[lines.length-1]);
			}
			else
			{
				r += lines[0]+"@"+list.get(0)+",";
				for ( int i = 1; i  < list.size() -1; i+=2 )
					r += list.get(i)+"@"+list.get(i+1)+",";
				r += list.get(list.size()-1)+"@"+lines[lines.length-1];
				System.out.println(r);
			}
		}
	}
}
}
