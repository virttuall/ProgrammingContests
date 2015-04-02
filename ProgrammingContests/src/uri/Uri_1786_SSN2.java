package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1786_SSN2 {
	public static int[] parseInts(String line) {
		int n = line.length();
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(line.charAt(i)+"");
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
	int arr[], b1, b2, sum1, sum2;
	char[] r;
	while ((line = in.readLine()) != null) {
		arr = parseInts(line);
		r = line.toCharArray();
		sum1 = sum2 = 0;
		for ( int i  = 1; i <= 9; i++ )
		{
			sum1 += i*arr[i-1];
			sum2 += (10-i)*arr[i-1];
		}
		b1 = sum1 % 11;
		b2 = sum2 %11;
		if (b1 == 10) b1 = 0;
		if (b2 == 10) b2 = 0;
		out.append(line.substring(0, 3)+"."+line.substring(3, 6)+"."+line.substring(6, 9)+"-"+b1+""+b2+"\n");
		//out.append()
	}
	System.out.print(out);
}
}
