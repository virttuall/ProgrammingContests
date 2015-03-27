package uri;
import java.io.*;
import java.util.*;
import java.math.*;
public class Uri_1001_ExtremelyBasic {


public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int a, b;
	while ((line = in.readLine()) != null) {
		a = Integer.parseInt(line);
		b = Integer.parseInt(in.readLine());
		out.append("X = "+(a+b)+"\n");
	}
	System.out.print(out);
}
}
