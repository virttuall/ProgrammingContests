import java.io.*;
import java.math.*;
import java.util.*;
public class CF_649B_MischievousMessMaker {
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	lines = in.readLine().split("\\s+");
	long n, k;
	n = Integer.parseInt(lines[0]);
	k = Integer.parseInt(lines[1]);
	long m = n/2l;
	k = Math.min(m, k);
	long a, b;
	long sum = 0l;
	for( int i = 0; i < k; i++ )
	{
		a = i;
		b = n-1l-i;
		sum += n-1l-a;
		sum += n-1l-b;
	}
	sum += k*(n-2*k);
	System.out.println(sum);
}
}
