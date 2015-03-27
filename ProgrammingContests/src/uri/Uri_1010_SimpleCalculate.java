package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1010_SimpleCalculate {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	double unit1, unit2, price1, price2;
	while ((line = in.readLine()) != null) {
		lines = line.split(" ");
		unit1 = Double.parseDouble(lines[1]);
		price1 = Double.parseDouble(lines[2]);
		lines = in.readLine().split(" ");
		unit2 = Double.parseDouble(lines[1]);
		price2 = Double.parseDouble(lines[2]);
		out.append("VALOR A PAGAR: R$ "+String.format("%.02f", unit1*price1+unit2*price2)+"\n");
	}
	System.out.print(out);
}
}
