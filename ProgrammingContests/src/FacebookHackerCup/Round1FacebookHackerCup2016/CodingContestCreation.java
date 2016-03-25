import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.io.*;
import java.math.*;

public class CodingContestCreation {
public static void main(String[] args) throws IOException{
	File file = new File("coding_contest_creation.txt");
	BufferedReader in = new BufferedReader( file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	PrintWriter print = new PrintWriter("salida1_1.txt");
	int T, N, data[];
	int result; 
	LinkedList<Integer> list;
	T = Integer.parseInt(in.readLine());
	for( int t = 0; t < T; t++ )
	{
		N = Integer.parseInt(in.readLine());
		data = parseInt(in.readLine());
		result = 0;
		list = new LinkedList<Integer>();
		list.add(data[0]);
		for( int i = 1; i < N; i++ )
		{
			if ( data[i-1] >= data[i] )
			{
				result += getResult(list);
				list = new LinkedList<Integer>();
			}
			list.add(data[i]);

		}
		result += getResult(list);
		print.println("Case #"+(t+1)+": "+result);
		System.out.println("Case #"+(t+1)+": "+result);
	}
	print.close();
}
public static int getResult(LinkedList<Integer> list)
{
	int result = 0;
	int sizeC = 1;
	int dif;
	for( int i = 1; i < list.size(); i++ )
	{
		dif = list.get(i) - list.get(i-1);
		if ( sizeC % 4 == 0 || dif <= 10)
		{
			sizeC++;
		}
		else
		{
			if ( sizeC % 4 == 1)
			{
				if ( dif <= 20 )
				{
					//1
					result++;
					sizeC = 3;
				}
				else if ( dif <= 30)
				{
					//2
					result+=2;
					sizeC = 0;
				}
				else
				{
					//3
					result+=3;
					sizeC = 1;
				}
			}
			else if( sizeC % 4 == 2)
			{
				if ( dif > 20 )
				{
					result += 2;
					sizeC = 1;
				}
				else
				{
					result++;
					sizeC = 0;
				}
			}
			else
			{
				result++;
				sizeC=1;
			}
		}
		
	}
	int add = sizeC % 4;
	if ( add != 0)
		result += (4-add);
	return result;
}
public static int[] parseInt(String line)
{
	String lines[] = line.split("\\s+");
	int result[] = new int[lines.length];
	for( int i = 0; i < result.length; i++ )
	{
		result[i] = Integer.parseInt(lines[i]);
	}
	return result;
}
}
