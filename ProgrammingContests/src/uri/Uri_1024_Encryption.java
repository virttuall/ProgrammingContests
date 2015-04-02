package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1024_Encryption {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int n = Integer.parseInt(in.readLine());
	char arr[];
	String s;
	for ( int i=0 ; i < n; i++ )
	{
		arr =in.readLine().toCharArray();
		for ( int j = 0; j<  arr.length; j++ )
		{
			if ( ( arr[j] >= 'a' && arr[j] <= 'z' ) || ( arr[j] >= 'A' && arr[j] <= 'Z' )) 
			{
				arr[j] = (char)(arr[j]+3);
			}
		}
		s = new StringBuilder(new String(arr)).reverse().toString();
		arr = s.toCharArray();
		for ( int j = arr.length/2; j < arr.length; j++ )
		{
			arr[j] = (char)(arr[j]-1);
		}
		out.append(new String(arr)+"\n");
	}
	System.out.print(out);
}
}
