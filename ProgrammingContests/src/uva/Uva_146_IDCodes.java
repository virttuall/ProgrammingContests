package uva;

import java.io.*;
import java.util.*;

public class Uva_146_IDCodes
{
	public static int arr[], l;
	public static boolean next_permutation()
	{
		int idPivot = -1;
		for ( int i = l - 1; i > 0; i-- )
		{
			if ( arr[i] > arr[i-1] )
			{
				idPivot = i-1;
				break;
			} 
		}
		if ( idPivot == -1 ) return false;
		for ( int i = l - 1; i > idPivot; i-- )
		{
			if ( arr[i] > arr[idPivot] )
			{
				arr[i] = arr[i] + arr[idPivot] - ( arr[idPivot] = arr[i] );
				break; 
			}
		}
		int m = (l-1)-(idPivot+1)+1;
		for( int i = 0, id1 = idPivot +1, id2 = l-1; i < m/2; i++, id1++, id2-- )
		{
			arr[id1] = arr[id1] + arr[id2] - ( arr[id2] = arr[id1]);
		}
		return true;
	}
	public static void main(String[] args) throws IOException
	{
		String line, result;
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		while(true)
		{
			line = in.readLine();
			if ( line.equals("#")) break;
			l = line.length();
			arr = new int[l];

			for( int i = 0; i < l; i++ ) arr[i] = (int)(line.charAt(i));
			if ( next_permutation()) 
			{
				result = "";
				for ( int i = 0; i < l; i++ ) result += (char)(arr[i]);
				out.append(result+"\n");
			}
			else
			{
				out.append("No Successor\n");
			}
		}
		System.out.print(out);
	}
}