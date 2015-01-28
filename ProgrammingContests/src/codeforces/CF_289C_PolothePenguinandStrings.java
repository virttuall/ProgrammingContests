package codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_289C_PolothePenguinandStrings{
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n, k;
    StringBuilder cad = new StringBuilder(), abc = new StringBuilder();
    for ( int i = 0; i < 500002; i++ )
    {
        cad.append("ab");
    }
    for ( int i = 2; i < 27; i++ )
    {
        abc.append((char)(97+i));
    }
    lines = input.readLine().split(" ");
    n = Integer.parseInt(lines[0]);
    k = Integer.parseInt(lines[1]);
    if ( (k == 1 && n != 1) || k > n)
    {
        System.out.println("-1");
    }
    else if ( k != 1)
    {
        System.out.println(cad.substring(0, n- k + 2)+abc.substring(0, k - 2 ));
    }
    else
    {
        System.out.println("a");
    }
    
}
}