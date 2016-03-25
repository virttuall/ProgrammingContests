import java.io.*;
import java.math.*;
import java.util.*;
public class Uva_10308_RoadsInTheNorth {
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	int a, b, c;
	ArrayList<Integer> graphV[] = new ArrayList[10001];
	for( int i = 1; i <= 10000; i++ ) graphV[i] = new ArrayList<Integer>();
	ArrayList<Integer> graphS[] = new ArrayList[10001];
	for( int i = 1; i <= 10000; i++ ) graphS[i] = new ArrayList<Integer>();
	int n = 0;
	while( (line = in.readLine()) != null )
	{
		if ( line.trim().equals("") )
		{
			out.append(algorithm(graphV, graphS, n)+"\n");
			graphV = new ArrayList[10001];
			for( int i = 1; i <= 10000; i++ ) graphV[i] = new ArrayList<Integer>();
			graphS = new ArrayList[10001];
			for( int i = 1; i <= 10000; i++ ) graphS[i] = new ArrayList<Integer>();
		}
		else
		{
			lines = line.split("\\s+");
			a = Integer.parseInt(lines[0]);
			b = Integer.parseInt(lines[1]);
			c = Integer.parseInt(lines[2]);
			graphV[a].add(b); graphS[a].add(c);
			graphV[b].add(a); graphS[b].add(c);
			n++;
		}
	}
	out.append(algorithm(graphV, graphS, n)+"\n");
	System.out.print(out);
}
public static int algorithm(ArrayList<Integer> graphV[], ArrayList<Integer> graphS[], int n)
{
	return subAlg(graphV, graphS, n, subAlg(graphV, graphS, n, 1 )[0] )[1];
}
public static int[] subAlg(ArrayList<Integer> graphV[], ArrayList<Integer> graphS[], int n, int index)
{
	int result[] = new int[2];
	
	
	Stack<Integer> stack = new Stack<Integer>();
	stack.add(index);
	int node, neig;
	boolean visited[] = new boolean[n+2];
	int values[] = new int[n+2];
	values[index] = 0;
	visited[index] = true;
	while( !stack.isEmpty() )
	{
		node = stack.pop();
		for( int i = 0; i < graphV[node].size(); i++ )
		{
			neig = graphV[node].get(i);
			if ( visited[neig] )  continue;
			visited[neig] = true;
			values[neig] = values[node] + graphS[node].get(i);
			stack.push(neig);
		}
	}
	int max = Integer.MIN_VALUE;
	int ind = -1;
	for( int i = 1; i <= n+1; i++ )
	{
		if ( values[i] >  max )
		{
			ind = i;
			max = values[i];
		}
	}
	result[0] = ind;
	result[1] = max;
	return result;
}
}
