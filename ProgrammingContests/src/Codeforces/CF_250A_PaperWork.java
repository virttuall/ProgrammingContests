package Codeforces;

import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;
public class CF_250A_PaperWork {
	public static int[] parseArrInt(String[] arr) {
		int r[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			r[i] = Integer.parseInt(arr[i]);
		}
		return r;
	}
public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String line = "";
    int v[], n, c = 0, enCarpetas = 0, countN = 0;
    n = Integer.parseInt(in.readLine());
    v = parseArrInt(in.readLine().split(" "));
    String salida = "";
    for( int i = 0; i < v.length; i++ )
    {
    	if ( v[i] < 0 ) 
    	{
    		countN++;
    		if ( countN == 3) 
    		{
    			c++;
    	        salida += (i - enCarpetas )+" ";
    	        enCarpetas = i;
    	        countN = 1;
    		}
    	}
    }
    System.out.println(c+1);
    System.out.println(salida+(v.length-enCarpetas));
}
}