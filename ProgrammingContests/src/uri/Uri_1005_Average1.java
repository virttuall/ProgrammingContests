package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1005_Average1 {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	double a, b;
	while ((line = in.readLine()) != null) {
		a = Double.parseDouble(line);
		b = Double.parseDouble(in.readLine());
		out.append("MEDIA = "+String.format("%.05f", (a*0.35+b*0.75)/1.1)+"\n");
	}
	System.out.print(out);
}
}
