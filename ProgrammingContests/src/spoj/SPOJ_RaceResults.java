package spoj;
import java.io.*;
import java.util.*;
import java.math.*;
public class SPOJ_RaceResults {
static class Time implements Comparable<Time>
{
	int hours;
	int minutes;
	int seconds;
	int size;
	public Time( int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		size = hours * 3600 +  minutes * 60 + seconds;
	}
	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		return new Integer(size).compareTo(o.size);
	}
	public String toString()
	{
		return hours + " "+ minutes + " "+ seconds;
	}
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
	int n = Integer.parseInt(in.readLine());
	Time times[] = new Time[n];
	for ( int i = 0; i< n; i++ )
	{
		lines = in.readLine().split(" ");
		Integer.parseInt(lines[0]);
		times[i] = new Time(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), Integer.parseInt(lines[2]));
	}
	Arrays.sort(times);
	for ( int i = 0; i<  n; i++ ) out.append(times[i].toString()+"\n");
	System.out.print(out);
}
}
