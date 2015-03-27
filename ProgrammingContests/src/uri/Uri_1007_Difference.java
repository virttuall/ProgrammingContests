package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1007_Difference {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int a, b, c, d;
	while ((line = in.readLine()) != null) {
		a = Integer.parseInt(line);
		b = Integer.parseInt(in.readLine());
		c = Integer.parseInt(in.readLine());
		d = Integer.parseInt(in.readLine());
		out.append("DIFERENCA = "+(a*b-c*d)+"\n");
	}
	System.out.print(out);
}
}
