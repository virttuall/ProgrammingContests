import java.io.*;
import java.math.*;
import java.util.*;
public class CF_620C_PearlsInARow {
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	int n;
	n = Integer.parseInt(in.readLine());
	lines = in.readLine().split("\\s+");
	int types[] = new int[n];
	for( int i = 0; i < n; i++) types[i] = Integer.parseInt(lines[i]);
	Set<Integer> set = new TreeSet<Integer>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(0);
	set.add(types[0]);
	for( int i = 1; i < n; i++ )
	{
		if ( set.contains(types[i]) )
		{
			list.add(i);
			set = new TreeSet<Integer>();
			if ( i == n-1 )
			{
				break;
			}
			else
			{
				list.add(i+1);
			}
			
		}
		else
		{
			set.add(types[i]);
		}
	}
	if ( list.size() == 1)
	{
		out.append("-1\n");
	}
	else
	{
		if ( list.size() % 2 == 1)
		{
			list.remove(list.size()-1);
			list.remove(list.size()-1);
			list.add(n-1);
		}
		out.append(((int)(list.size()/2))+"\n");
		for( int i = 0; i < list.size(); i+= 2) out.append((1+list.get(i))+" "+(1+list.get(i+1))+"\n");
	}
	System.out.print(out);
}
}