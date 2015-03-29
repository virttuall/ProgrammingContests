package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1013_TheGreatest {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int a, b, c, max1, max2, max3;
	while ((line = in.readLine()) != null) {
		lines = line.split(" ");
		a = Integer.parseInt(lines[0]);
		b = Integer.parseInt(lines[1]);
		c = Integer.parseInt(lines[2]);
		max1 = (a+b+Math.abs(a-b))/2;
		max2 = (a+c+Math.abs(a-c))/2;
		max3 = (c+b+Math.abs(c-b))/2;
		max1 = Math.max(Math.max(max1, max2), max3);
		out.append(max1+" eh o maior\n");
	}
	System.out.print(out);
}
}
