package Codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_118B_PresentfromLena {
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("i");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line, lines[];
    int n, data[];
    String vacio = new String("");
    for ( int i = 0; i < 100; i++ ) vacio += " ";
    n = Integer.parseInt(in.readLine());
    int j;
    for ( int i = 0; i < n; i++ )
    {
        line = "";
        
        for (  j = 0; j <= i; j++)
        {
            line += j+ " ";
        }
        j--;
        j--;
        for ( ; j > -1; j--)
        {
            line += j+" ";
        }
        System.out.println(vacio.substring(0, 2*(n-i))+line.trim());
    }
    
    line = "";
    
    for (  j = 0; j <= n-1; j++)
    {
        line += j+ " ";
    }
    j--;
    line += n+" ";
    for ( ; j > -1; j--)
    {
        line += j+" ";
    }
    System.out.println(line.trim());
    
    for ( int i = n-1; i > -1; i-- )
    {
        line = "";
        for (  j = 0; j <= i; j++)
        {
            line += j+ " ";
        }
        j--;
        j--;
        for ( ; j > -1; j--)
        {
            line += j+" ";
        }
        System.out.println(vacio.substring(0, 2*(n-i))+line.trim());
    }
    System.out.print(out);
}
}