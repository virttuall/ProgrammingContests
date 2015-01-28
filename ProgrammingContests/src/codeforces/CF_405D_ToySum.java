package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_405D_ToySum{
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n = Integer.parseInt(input.readLine()), c = 0, aux;
    output.append(n+"\n");
    boolean flags[] = new boolean[1000001];
    lines = input.readLine().split(" ");
    for ( int i = 0; i < n; i++ )
    {
        flags[Integer.parseInt(lines[i])] = true;
    }
    for ( int i = 1; i <= 1000000 ; i++ )
    {
        aux = 1000000-i+1;
        if ( flags[i] && !flags[aux])
        {
            output.append(aux);
            c++;
            if ( c != n)
            {
                output.append(" ");
            }
        }
    }
    for ( int i = 1; i <= 1000000; i++ )
    {
        aux = 1000000-i+1;
        if ( c != n && !flags[aux] && !flags[i])
        {
            output.append(i + " "+ aux);
            c += 2;
            if ( c!= n)
            {
                output.append(" ");
            }
        }
    }
    System.out.println(output);
}
}