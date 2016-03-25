import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Laundro_Matt {
	public static class Node implements Comparable<Node>
	{
		long time;
		long jump;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
		    return new Long(time).compareTo(o.time);
		}
		public Node( long time, long jump)
		{
			this.time = time;
			this.jump = jump;
		}
		
	}
	public static long max(long a, long b)
	{
		if ( a > b) return a;
		return b;
	}
	public static void main(String[] args) throws IOException {
		File file = new File("laundro_matt.txt");
		BufferedReader in = new BufferedReader( file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
		PrintWriter print = new PrintWriter("salida1_2.txt");
		PriorityQueue<Node> queue;
		PriorityQueue<Long> q;
		int T, L, N, M, D;
		long data[];
		long times[], value;
		long max;
		T = Integer.parseInt(in.readLine());
		String lines[];
		Node aux;
		long result;
		long s;
		for( int t=1; t<= T; t++)
		{
			lines = in.readLine().split("\\s+");
			L = Integer.parseInt(lines[0]);
			N = Integer.parseInt(lines[1]);
			M = Integer.parseInt(lines[2]);
			D = Integer.parseInt(lines[3]);
			data = parseLongs(in.readLine());
			queue = new PriorityQueue<Node>();
			for( int i = 0; i < N; i++ )
			{
				queue.add(new Node(data[i], data[i]));
			}
			times = new long[L];
			for( int i = 0; i < L; i++ )
			{
				aux = queue.poll();
				times[i] = aux.time;
				aux.time += aux.jump;
				queue.add(aux);
			}
			result = 0;
			q = new PriorityQueue<Long>();
			if ( M > 1000000 ) M =L;
			for( int i = 0; i < M; i++ )
			{
				q.add(0l);
			}
			s = 0;
			max = 0;
			for( int i = 0; i < L; i++)
			{
				s = q.poll();
				max = max(s, times[i]);
				q.add(max+D);
			}
			result = max + +D;
			System.out.println("Case #"+t+": "+(result));
			print.println("Case #"+t+": "+(result));
		}
		print.close();
	}
	public static long[] parseLongs(String line)
	{
		String lines[] = line.split("\\s+");
		long result[] = new long[lines.length];
		for( int i = 0; i < lines.length; i++ )
		{
			result[i] = Long.parseLong(lines[i]);
		}
		return result;
	}
}
