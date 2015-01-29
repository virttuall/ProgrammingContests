package spoj;
import java.io.*;
import java.util.*;
import java.math.*;
public class SPOJ_YODANESS {
	static int ft[];
	static void init( int n) { ft = new int[n+1]; }
	static int LSOne( int i ) { return i & (-i);}
	static int rsq( int a) 
	{ 
		int sum = 0;
		for (; a != 0; a -=LSOne(a)) sum += ft[a];
		return sum;
	}
	static int rsq( int a, int b)
	{
		return rsq(b) - ( a == 1 ? 0 : rsq(a-1));
	}
	static void adjust( int k, int v)
	{
		for ( ; k < ft.length; k += LSOne(k) ) ft[k] += v;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in;
		StringBuilder out = new StringBuilder();
		File file = new File("in");
		if (file.exists())
			in = new BufferedReader(new FileReader(file));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		String line, lines[];
		int t = Integer.parseInt(in.readLine()), nW, arr[], aux, total;
		Map<String , Integer> map;	
		for ( int c = 0;  c < t; c++)
		{
			nW = Integer.parseInt(in.readLine());
			init(nW);
			lines = in.readLine().split("\\s+");
			map = new HashMap<String, Integer>();
			for ( int i = 0; i < nW; i++ ) map.put(lines[i], i+1);
			lines = in.readLine().split("\\s+");
			arr = new int[nW+1];
			total = 0;
			for ( int i = 0; i < nW; i++)
			{
				aux = map.get(lines[i]);
				total += rsq(aux, nW);
				adjust(aux, 1);
			}
			out.append(total+"\n");
		}
		System.out.print(out);
	}
}
