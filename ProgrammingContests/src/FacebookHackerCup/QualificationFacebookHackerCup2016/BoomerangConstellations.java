import java.io.*;
import java.util.Arrays;

public class BoomerangConstellations {
	public static void main(String[] args) throws IOException{
		BufferedReader in;
		StringBuilder out = new StringBuilder("");
		File file = new File("boomerang_constellations.txt");
		if ( file.exists()) in = new BufferedReader(new FileReader(file));
		else in = new BufferedReader( new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int N;
		int xs[], ys[], x, y;
		double vs[];
		String lines[], line;
		//System.out.println(Integer.MAX_VALUE);
		int c;
		double a;
		long result;
		PrintWriter print = new PrintWriter("salida.txt");
		for( int i = 0; i < T; i++ )
		{
			result = 0;
			N = Integer.parseInt(in.readLine());
			xs = new int[N];
			ys = new int[N];
			for( int j = 0; j < N; j++ )
			{
				lines = in.readLine().split("\\s+");
				xs[j] = Integer.parseInt(lines[0]);
				ys[j] = Integer.parseInt(lines[1]);
			}
			for( int j = 0; j < N; j++ )
			{
				vs = new double[N];
				for( int k = 0; k < N; k++ )
				{
					if ( j == k) continue;
					x = abs(xs[j]-xs[k]);
					y = abs(ys[j]-ys[k]);
					vs[k] = Math.hypot(x, y);
				}
				Arrays.sort(vs);
				a = vs[0];
				c = 1;
				for( int k = 1; k < vs.length; k++ )
				{
					if ( vs[k] == a )
					{
						c++;
					}
					else
					{
						
						result += (c*(c-1))/2;
						c = 1;
						a = vs[k];
					}
				}
				result += (c*(c-1))/2;	
			}
			//System.out.println("Case #"+(i+1)+": "+result);
			out.append("Case #"+(i+1)+": "+result+"\n");
			print.println("Case #"+(i+1)+": "+result);
			
		}
		
		//print.print(out);
		print.close();
		System.out.print(out);
		
			
		
	}
	public static int abs(int a)
	{
		if ( a < 0 ) return -1*a;
		return a;
	}
}
