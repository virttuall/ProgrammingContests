package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_296C_GregandArray{
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n, m , k, x, y;
    long arr[], arr2[], countQuery[], querys[][];
    lines = input.readLine().split(" ");
    n = Integer.parseInt(lines[0]);
    m = Integer.parseInt(lines[1]);
    k = Integer.parseInt(lines[2]);
    lines = input.readLine().split(" ");
    arr = new long[lines.length];
    arr2 = new long[lines.length+1];
    for ( int i = 0; i < lines.length; i++ )
    {
        arr[i] = Long.parseLong(lines[i]);
    }
    querys = new long[m][3];
    countQuery = new long[m+1];
    for ( int i = 0; i < m ; i++ )
    {
        lines = input.readLine().split(" ");
        querys[i][0] = Long.parseLong(lines[0])-1;
        querys[i][1] = Long.parseLong(lines[1])-1;
        querys[i][2] = Long.parseLong(lines[2]);
    }
    for ( int i = 0; i <k; i++ )
    {
        lines = input.readLine().split(" ");
        x = Integer.parseInt(lines[0])-1;
        y = Integer.parseInt(lines[1])-1;
        countQuery[x]++;
        countQuery[y+1]--;
    }
    for ( int i = 0; i < m; i++ )
    {
        countQuery[i+1] += countQuery[i];
    }
    for ( int i = 0; i < m; i++ )
    {
        arr2[(int)querys[i][0]] += querys[i][2]*countQuery[i];
        arr2[(int)querys[i][1]+1] -= querys[i][2]*countQuery[i]; 
    }
    for ( int i= 0; i < n; i++ )
    {
        arr2[i+1] += arr2[i];
    }
    for ( int i = 0; i < n; i++ )
    {
        output.append(arr[i]+arr2[i]);
        if ( i != n-1) output.append(" ");
    }
    System.out.println(output);
}
}