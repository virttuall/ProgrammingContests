package uva;
import java.io.*;
import java.util.*;
import java.math.*;
public class Uva_10038_JollyJumpers {
	public static int[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(lines[i]);
		}
		return r;
	}
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int arr[], n, aux;
	boolean flag = true;
	while ((line = in.readLine()) != null) {
		arr = parseInts(line);
		n = arr.length-1;
		for ( int i = 0; i <  n; i++ )
		{
			aux = Math.abs(arr[i] - arr[i+1]);
			if ( aux > n) flag = false;
		}
		if ( flag ) out.append("Jolly\n");
		else out.append("Not jolly\n");
	}
	System.out.print(out);
}
}
