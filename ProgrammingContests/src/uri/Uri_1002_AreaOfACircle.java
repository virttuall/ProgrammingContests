package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1002_AreaOfACircle {
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
	DecimalFormat df = new DecimalFormat("#.####");

	while ((line = in.readLine()) != null) {
		r = Double.parseDouble(line);
		out.append("A="+(String.format("%.04f", pi*r*r ))+"\n");
	}
	System.out.print(out);
}
}
