package codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_447B_DZY_LovesStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String line, lines[];
        char S[] = input.readLine().toCharArray();
        int k = Integer.parseInt(input.readLine());
        int v[] = new int[26];
        lines = input.readLine().split(" ");
        for ( int i = 0; i < 26; i++ )
        {
            v[i] = Integer.parseInt(lines[i]);
        }
        
        
        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < 26; i++ )
            if ( v[i] > max )
                max = v[i];
        long sum= 0;
        int i = 0;
        for ( ; i < S.length; i++ )
        {
            sum += (i+1)*v[((int)S[i])-97];
        }
        for ( int j = 0; j < k; j++, i++ )
        {
            sum += (i+1)*max;
        }
        System.out.print(sum);
    }
}