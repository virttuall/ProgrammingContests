import java.io.*;
import java.math.*;
import java.util.*;
public class Uva_10139_Factovisors {
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	long a, b, t, v, c, bb;
	TreeSet<Long> values;
	ArrayList<Long> list;
	while( (line=in.readLine()) != null)
	{
		line = line.trim();
		if ( line.equals("")) break;
		lines = line.split("\\s+");
		a = Long.parseLong(lines[0]);
		b = Long.parseLong(lines[1]);
		bb = b;
		if ( b == 1l)
		{
			out.append("1 divides "+a+"!\n");
		}
		else
		{
			t = (long)Math.ceil(Math.sqrt(b));
			list = new ArrayList<Long>();
			for( long i = 2l; i <= t; i++)
			{
				if( b % i == 0l )
				{
					v = i; c = 0l;
					while( b % i == 0l )
					{
						b /= i;
						c++;
					}
					list.add(v);
					list.add(c);
				}
			}
			if ( b != 1 )
			{
				list.add(b);
				list.add(1l);
			}
			boolean flag = true;
			for( int i = 0; i < list.size(); i+=2)
			{
				v = list.get(i);
				c = list.get(i+1);
				if ( c > f(a, v))
				{
					flag = false;
				}
			}
			if ( flag ) out.append(bb +" divides "+a+"!\n");
			else out.append(bb +" does not divide "+a+"!\n");
		}
	}
	System.out.print(out);
}
public static long f(long f, long n){
	long result = 0l;
	long nn = n;
	while( nn <= f )
	{
		result += (f/nn);
		nn *= n; 
	}
	return result;
}
}
