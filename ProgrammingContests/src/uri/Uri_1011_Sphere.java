package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1011_Sphere {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	double r, pi = 3.14159;
	while ((line = in.readLine()) != null) {
		r = Double.parseDouble(line);
		out.append("VOLUME = "+String.format("%.03f",(4.0/3.0)*pi*r*r*r)+"\n");
	}
	System.out.print(out);
}
}
