import java.io.*;
import java.util.*;

public class ThePriceIsCorrect {
public static void main(String[] args) throws IOException {
	File file = new File("the_price_is_correct.tx");
	BufferedReader in = new BufferedReader( file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	PrintWriter print = new PrintWriter("salida3.txt");
	int N, T;
	long vs[], P;
	String lines[];
	long result, sum;
	T = Integer.parseInt(in.readLine());
	boolean flag;
	for( int t = 0; t < T; t++ )
	{
		lines = in.readLine().trim().split("\\s+");
		N = Integer.parseInt(lines[0]);
		P = Long.parseLong(lines[1]);
		vs = new long[N+1];
		lines = in.readLine().trim().split("\\s+");
		for( int i = 0; i < N; i++ )
		{
			vs[i] = Long.parseLong(lines[i]);
		}
		vs[N] = 2000000000;
		int l, r, rb;
		l = r = 0;
		result = 0;
		flag = true;
		sum = vs[0];
		rb = -1;
		long v, v2;
		while(r <= N-1)
		{
			if ( sum <= P)
			{
				v = ((long)(r-l+1));
				result += (v*(v+1))/2;
				if ( rb >= l)
				{
					v2 = ((long)(rb-l+1));
					result -= (v2*(v2+1))/2;
				}
				rb = r;
				
			}
			if ( sum < P)
			{
				r++;
				sum += vs[r];
			}
			else
			{
				if ( r == l)
				{
					r++;
					l++;
					sum = vs[r];
				}
				else
				{
					sum -= vs[l];
					l++;
				}
			}
		}
		if ( sum <= P)
		{
			
			v = ((long)(r-l+1));
			result += (v*(v+1))/2;
			if ( rb >= l)
			{
				v2 = ((long)(rb-l+1));
				result -= (v2*(v2+1))/2;
			}		
		}
		System.out.println("Case #"+(t+1)+": "+result);
		print.println("Case #"+(t+1)+": "+result);
		
	}
	print.close();

}
}
