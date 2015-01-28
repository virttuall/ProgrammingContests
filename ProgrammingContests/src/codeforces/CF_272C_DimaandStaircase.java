package codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_272C_DimaandStaircase{
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    long matrix[], l;
    int n, m, w, h;
    n = Integer.parseInt(input.readLine());
    lines = input.readLine().split(" ");
    matrix = new long[n+1];
    for ( int i = 0; i < n; i++ )
    {
        matrix[i+1] = Long.parseLong(lines[i]);
    }
    m = Integer.parseInt(input.readLine());
    l = 0;
    for ( int i = 0; i < m ;i++ )
    {
        lines = input.readLine().split(" ");
        w = Integer.parseInt(lines[0]);
        h = Integer.parseInt(lines[1]);
        l = ( l > matrix[w]) ? l: matrix[w];
        output.append(l+"\n");
        l += h;
    }
    System.out.print(output);
}
}