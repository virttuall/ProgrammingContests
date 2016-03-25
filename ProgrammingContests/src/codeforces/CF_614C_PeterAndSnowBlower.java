import java.awt.geom.Line2D;
import java.io.*;
import java.math.*;
import java.util.*;



public class CF_614C_PeterAndSnowBlower {
	public static int x, y;
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	lines = in.readLine().split("\\s+");
	int  n, x1, y1;
	n = Integer.parseInt(lines[0]);
	int c = 1000000;
	x = Integer.parseInt(lines[1]);
	y = Integer.parseInt(lines[2]);
	double d1;
	double min = Double.MAX_VALUE;
	double max = Double.MIN_VALUE;
	int xs[] = new int[n], ys[] = new int[n];
	for( int i = 0; i < n; i++ )
	{
		lines = in.readLine().split("\\s+");
		xs[i] = Integer.parseInt(lines[0]);
		ys[i] = Integer.parseInt(lines[1]);
		d1 = Math.hypot(Math.abs(xs[i]-x), Math.abs(ys[i]-y));
		max = Math.max(max, d1);
	}
	for( int i = 0; i < n; i++ )
	{
		min = Math.min(min, dis( xs[i], ys[i], xs[(i+1)%n], ys[(i+1)%n]));
	}
	double result = Math.PI*(max*max-min*min);
	System.out.println(result);
}
public static double dis( int x1, int y1, int x2, int y2)
{
	Point p1 = new Point(x1, y1);
	Point p2 = new Point(x2, y2);
	Point p = new Point(x, y);
	Point r = pointNearestToSegment(p1, p2, p);
	return dist(p, r);
	//return Line2D.ptSegDist(x1, y1, x2, y2, x,y);	
}
public static double dist(Point p1, Point p2)
{
	return Math.hypot(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
}
public static Point pointNearestToSegment(Point p1, Point p2, Point p) //p1 != p2
{
	double r = ((p.x-p1.x)*(p2.x-p1.x)+(p.y-p1.y)*(p2.y-p1.y))/((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
	double pjx = r*(p2.x-p1.x);
	double pjy = r*(p2.y-p1.y);
	double d = ( pjx == 0.0) ? pjy/(p2.y-p1.y) : pjx/(p2.x-p1.x);
	if ( d > 1) return p2;
	if ( d < 0) return p1;
	return new Point(p1.x+pjx, p1.y+pjy);
}
public static class Point
{
	double x, y;
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public String toString()
	{
		return x+" "+y;
	}
}
}