package Uri;

import java.util.*;
import java.io.*;

public class Uri_1396_ThereSAnExamFromCrisToday {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		LinkedList<String> list, sortList, listR;
		int n, k, l, index, r = 1;
		String lines[], line, aux;
		while( !( line = input.readLine()).equals("0 0") )
		{
			lines = line.split(" ");
			n = Integer.parseInt(lines[0]);
			k = Integer.parseInt(lines[1]);
			lines = input.readLine().split(" ");
			list = new LinkedList<String>();
			sortList = new LinkedList<String>();
			listR = new LinkedList<String>();
			for( int i = 0; i < n; i++ )
			{
				list.add(lines[i]);
				sortList.add(lines[i]);
			}
			Collections.sort(sortList);
			index = 0;
			for( int i = 0; i < n; i++ )
			{
				for ( int j = 0; j < n - i; j++ )
				{
					aux = sortList.get(j);
					l = list.indexOf(aux);
					if ( k >= l )
					{
						k -= l;
						listR.add(aux);
						sortList.remove(j);
						list.remove(l);
						break;
					}
				}
			}
			output.append("Instancia "+r+++"\n");
			for( int  i = 0; i < n; i++ )
			{
				output.append(listR.get(i)+" ");
			}
			output.append("\n\n");
		}
		System.out.print(output);
	}
}
