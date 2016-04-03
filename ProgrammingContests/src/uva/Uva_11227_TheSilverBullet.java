import java.io.*;
import java.math.*;
import java.util.*;

public class Uva_11227_TheSilverBullet {
	public static class Point
	{
		double x, y;
		public Point(double x, double y)
		{
			this.x = x; this.y = y;
		}
		@Override
		public boolean equals(Object ob)
		{
			Point o = (Point)ob;
			return  x == o.x && y == o.y;
		}
		@Override
		public int hashCode() {
			int result = 2;
			result = 101*result + new Double(x).hashCode();
			result = 101*result + new Double(y).hashCode();
			return result;
		}
	}
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	int t = Integer.parseInt(in.readLine());
	int c, count, max;
	double EPS = 1e-9;
	for( int i = 0; i < t; i++ )
	{
		int n = Integer.parseInt(in.readLine());
		HashSet<Point> set = new HashSet<Point>();
		for( int j = 0; j < n; j++ )
		{
			lines = in.readLine().split("\\s+");
			set.add(new Point(Double.parseDouble(lines[0]), Double.parseDouble(lines[1])));
		}
		c = 0;
		Point arr[] = new Point[set.size()];
		for( Point p : set ) arr[c++] = p;
		if ( c == 1)
		{
			out.append("Data set #"+(i+1)+" contains a  single gnu.\n");
			continue;
		}
		max = 1;
		for( int j = 0; j < arr.length; j++ )
		{
			for( int k = j+1; k < arr.length; k++ )
			{
				count = 2;
				for( int l = k + 1; l < arr.length; l++ )
				{
					if (  (arr[j].y-arr[l].y)*(arr[k].x-arr[l].x) == (arr[k].y-arr[l].y)*(arr[j].x-arr[l].x)  )
					{
						count++;
					}
				}
				if ( count > max) max = count;
			}			
		}
		out.append("Data set #"+(i+1)+" contains "+c+" gnus, out of which a maximum of "+max+" are aligned.\n");
	}
	System.out.print(out);
}
}
