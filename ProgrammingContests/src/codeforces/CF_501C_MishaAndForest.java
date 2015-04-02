package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_501C_MishaAndForest {
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
	int arrA[] = new int[n];
	int arrX[] = new int[n];
	Queue<Integer> list = new LinkedList<Integer>();
	int edge = 0;
	for ( int i = 0; i< n; i++ )
	{
		lines = in.readLine().split(" ");
		arrA[i] = Integer.parseInt(lines[0]);
		arrX[i] = Integer.parseInt(lines[1]);
		if ( arrA[i] == 1 )
		{
			list.add(i);
		}
		edge += arrA[i];
	}
	int v, t;
	edge /= 2;
	out.append(edge+"\n");
	while(!list.isEmpty())
	{
		v = list.poll();
		if ( arrA[v] != 1) continue; 
		t = arrX[v];
	    arrA[t]--;
	    arrX[t] ^= v;
	    if ( arrA[t] == 1 ) list.add(t);
	    out.append(v+" "+t+"\n");
	}
	System.out.print(out);
}
}
