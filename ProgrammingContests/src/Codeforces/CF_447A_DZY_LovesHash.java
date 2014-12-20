package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_447A_DZY_LovesHash {
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    lines = input.readLine().split(" ");
    long p = Long.parseLong(lines[0]);
    long n = Long.parseLong(lines[1]), k;
    int aux;

    boolean flags[] = new boolean[(int)p];
    int i = 0;
    for (; i < n; i++) {
        k = Integer.parseInt(input.readLine());
        aux = (int)(k%p);
        if ( flags[aux] == true )
        {
            
            System.out.println(i+1);
            break;
        }
        flags[aux] = true;
    }
    if ( i == n) System.out.println("-1");
}
}