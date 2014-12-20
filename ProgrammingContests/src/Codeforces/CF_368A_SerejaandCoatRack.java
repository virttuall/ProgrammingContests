package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CF_368A_SerejaandCoatRack {
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n, d, ai[], m, count, p, r;
    while(true)
    {
        line = input.readLine();
        if ( line == null || line.equals("")) break;
        lines = line.split(" ");
        count = p = r = 0;
        n = Integer.parseInt(lines[0]);
        d = Integer.parseInt(lines[1]);
        lines = input.readLine().split(" ");
        ai = new  int[n];
        for(int i = 0; i < n; i++ ) {ai[i] = Integer.parseInt(lines[i]); count+=ai[i];}
        m = Integer.parseInt(input.readLine());
        if ( m < n)
        {
            Arrays.sort(ai);
            p = 0;
            for( int i = 0; i < m; i++ ) p+=ai[i];
            output.append(p);
        
        }
        else
        {
            output.append(count-(m-n)*d);
        }   
        output.append("\n");
    }
    System.out.print(output);
}
}