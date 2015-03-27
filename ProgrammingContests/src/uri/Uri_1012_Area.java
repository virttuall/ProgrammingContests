package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1012_Area {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	double a, b, c, a1, a2, a3, a4, a5, pi = 3.14159;
	while ((line = in.readLine()) != null) {
		lines = line.split(" ");
		a = Double.parseDouble(lines[0]);
		b = Double.parseDouble(lines[1]);
		c = Double.parseDouble(lines[2]);
		a1 = (a*c)/2.0;
		a2 = pi*c*c;
		a3 = ((a+b)*c)/2;
		a4 = b*b;
		a5 = a*b;
		out.append("TRIANGULO: "+String.format("%.03f",a1)+"\n");
		out.append("CIRCULO: "+String.format("%.03f",a2)+"\n");
		out.append("TRAPEZIO: "+String.format("%.03f",a3)+"\n");
		out.append("QUADRADO: "+String.format("%.03f",a4)+"\n");
		out.append("RECTANGULO: "+String.format("%.03f",a5)+"\n");
	}
	System.out.print(out);
}	
}
