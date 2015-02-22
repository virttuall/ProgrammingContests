package uri;
import java.io.*;
import java.util.*;
import java.math.*;
public class Uri_1080_HighestAndPosition {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int arr[] = new int[100];
	int max = Integer.MIN_VALUE, index = -1;
	for ( int i = 0; i < 100; i++ )
	{
		arr[i] = Integer.parseInt(in.readLine());
		if ( arr[i] > max) {max = arr[i]; index = i+1;}
	}
	System.out.print(max+"\n"+index+"\n");
}
}
