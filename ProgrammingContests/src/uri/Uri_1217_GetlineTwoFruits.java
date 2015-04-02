package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1217_GetlineTwoFruits {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int n = Integer.parseInt(in.readLine()), aux;
	double sum1 = 0, sum2 = 0;
	for ( int i = 0; i<  n; i++ )
	{
		sum1 += Double.parseDouble(in.readLine());
		aux = in.readLine().split(" ").length;
		sum2 += aux;
		out.append("day "+(i+1)+": "+aux+" kg\n");
	}
	sum1 = sum1/(double)(n);
	sum2 = sum2/(double)(n);
	out.append(String.format("%.02f", sum2)+ " kg by day\n");
	out.append("R$ "+String.format("%.02f", sum1)+ " by day\n");
	System.out.print(out);
}
}
