package codeforces;


import java.util.*;
import java.math.*;
import java.io.*;

public class CF_276A_LunchRush {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n, k, fi, ti, max = Integer.MIN_VALUE, aux;
        String lines[];
        lines = in.readLine().split(" ");
        n = Integer.parseInt(lines[0]);
        k = Integer.parseInt(lines[1]);
        for( int i = 0; i < n; i++ )
        {
            lines = in.readLine().split(" ");
            fi = Integer.parseInt(lines[0]);
            ti = Integer.parseInt(lines[1]);
            if ( ti > k )
            {
                aux = fi - ( ti - k);
            }
            else
            {
                aux = fi;
            }
            if ( aux > max ) max = aux;
        }
        System.out.println(max);
    }
}
