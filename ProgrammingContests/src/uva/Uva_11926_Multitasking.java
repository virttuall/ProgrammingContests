package uva;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uva_11926_Multitasking {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[]; 
	int n, m , a, b, v, arr[], count;
	boolean flag;
	while ((line = in.readLine()) != null && !line.equals("0 0")) {
		lines = line.split(" ");
		n = Integer.parseInt(lines[0]);
		m = Integer.parseInt(lines[1]);
		arr = new int[1000002];
		for ( int i = 0; i < n; i++ )
		{
			lines = in.readLine().split(" ");
			a = Integer.parseInt(lines[0]);
			b = Integer.parseInt(lines[1]);
			arr[a] += 1;
			arr[b] -= 1;

		}
		for ( int i = 0; i<  m; i++ )
		{
			lines = in.readLine().split(" ");
			a = Integer.parseInt(lines[0]);
			b = Integer.parseInt(lines[1]);
			v = Integer.parseInt(lines[2]);
			for ( int j = 0; a+v*j < arr.length; j++ )
			{
				arr[a+v*j] += 1;
				if (  b+v*j < arr.length) arr[b+v*j] -= 1;
				else arr[1000001] -= 1;
			}
		}
		flag = true;
		count = 0;
		for ( int i = 0; i < arr.length; i++ )
		{
			count += arr[i];
			if ( count > 1)
			{
				flag = false;
				break;
			}
		}
		if ( flag ) out.append("NO CONFLICT\n");
		else out.append("CONFLICT\n");
	}
	System.out.print(out);
}
}
