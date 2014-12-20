package Uri;
import java.io.*;
import java.util.*;

public class Uri_1055_ElegantPermutedSum {
public static int v( int a, int b)
{
	int aux = a-b;
	if ( aux < 0 )
		aux *= -1;
	return aux;
}
public static int[] parse( String line)
{
	String[] lines = line.split(" ");
	int r[] = new int[lines.length-1];
	for( int i = 0; i < r.length; i++ )
	{
		r[i] = Integer.parseInt(lines[i+1]);
	}
	return r;
}
public static void add(LinkedList<Integer> list, int v, boolean left)
{
	if ( left )
	{
		list.add(0,v);
	}
	else
	{
		list.add(v);
	}
}
public static void main(String[] args) throws IOException{
	BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
	StringBuilder output = new StringBuilder();
	int n = Integer.parseInt(input.readLine()), data[], l, M, m, k, count;
	boolean odd, left;
	LinkedList<Integer> list;
	for( int i = 0; i < n; i++ )
	{
		data = parse(input.readLine());
		l = data.length-1;
		if ( data.length % 2 == 1 ) { odd = true; }
		else { odd = false; l++; }
	    Arrays.sort(data);
	    list = new LinkedList<Integer>();
	    list.add(data[0]);
	    m = 1;
	    M = data.length-1;
	    k = 1;
	    while( k != l)
	    {
	    	add( list, data[M--], false);
	    	k++;
	    	if ( k == l) break;
	    	add( list, data[M--], true);
	    	k++;
	    	if ( k == l) break;
	    	add( list, data[m++], false);
	    	k++;
	    	if ( k == l) break;
	    	add( list, data[m++], true);
	    	k++;
	    }
	    if ( odd )
	    {
	    	if ( v( data[m], list.get(0)) > v( data[m], list.get(list.size()-1)) )
	    	{
	    		list.add(0,data[m]);
	    	}
	    	else
	    	{
	    		list.add(data[m]);
	    	}
	    }
	    count = 0;
	    for( int j = 1; j < list.size(); j++ )
	    {
	    	count+= v( list.get(j),list.get(j-1));
	    }
	    output.append("Case "+(i+1)+": "+count+"\n");
	}
	System.out.print(output);
}
}
