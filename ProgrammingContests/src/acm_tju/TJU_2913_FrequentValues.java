package acm_tju;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class TJU_2913_FrequentValues {
	public static int init[], finish[], freq[], s;
	public static int[] parseInts(String line) {
		String lines[] = line.split(" ");
		int n = lines.length;
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(lines[i]);
		}
		return r;
	}
public static void update(int index)
{
	if ( index < 1 << (s-1) )
	{
		update(index*2);
		update(index*2+1);
	}
	init[index] = init[2*index];
	finish[index] = finish[2*index+1];
	freq[index] = ( freq[index*2+1] > freq[index*2] ) ? freq[index*2+1] : freq[index*2];
}

public static int query(int index, int a, int b)
{
	if ( index >= 1<<s ){ if ( finish[index] != b || init[index] != a) return b - a+1;}
	if ( a == init[index] && b == finish[index]) { return freq[index]; }
	if ( a >= init[index*2] && b <= finish[index*2]) return query(index*2, a, b);
	if ( a >= init[index*2+1] && b <= finish[index*2+1]) return query(index*2+1, a, b);
	return (int)Math.max(query(index*2, a, finish[index*2]), query(index*2+1, init[2*index+1],b));
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
	int n, q, arr[], a, b, countNumbers[], sizeF, index, indexCount;
	double aux;
	while ((line = in.readLine()) != null && !line.equals("0")) {
		lines = line.split(" ");
		n = Integer.parseInt(lines[0]);
		q = Integer.parseInt(lines[1]);
		arr = parseInts(in.readLine());
		countNumbers = new int[200001];
		sizeF = 0;
		for ( int i= 0; i < arr.length; i++ ) countNumbers[arr[i]+100000]++;
		for ( int i = 0; i<  countNumbers.length; i++ ) if ( countNumbers[i] != 0) sizeF++;
		aux = Math.log(sizeF)/Math.log(2);
		sizeF = (int)Math.ceil(aux);
		s = sizeF;
		sizeF = 1<<(sizeF+1);
		init = new int[sizeF];
		finish = new int[sizeF];
		freq = new int[sizeF];
		index = 0;
		indexCount = 0;
		for ( int i = 0 ;i<  countNumbers.length; i++ ) 
		{
			if ( countNumbers[i] != 0 )
			{
				init[(1<<s)+index] = indexCount;
			    finish[(1<<s)+index] = indexCount+countNumbers[i]-1;
			    freq[(1<<s)+index] = countNumbers[i];
			    indexCount += countNumbers[i];
				index++;
			}
		}
		for ( int i = (1<<s)+index ; i < init.length; i++ )
		{
			init[i] = indexCount;
			finish[i] = indexCount;
			freq[i] = 1;
			indexCount++;
		}
		update(1);
		for ( int i= 0; i<  q; i++ )
		{
			lines = in.readLine().split(" ");
			System.out.println(query(1, Integer.parseInt(lines[0])-1, Integer.parseInt(lines[1])-1));
		}
		
	}
}
}
