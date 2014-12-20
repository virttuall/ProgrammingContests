package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_119A_EpicGame {
    static long gcd(long a, long b){
        if (b == 0)
           return a;
        else
           return gcd(b, a % b);
    }
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String lines[], line;
    long a, b, n;
    while(true)
    {
        line = input.readLine();
        if ( line == null || line.equals("")) break;
        lines = line.split(" ");
        a = Long.parseLong(lines[0]);
        b = Long.parseLong(lines[1]);
        n = Long.parseLong(lines[2]);
        for( int i = 0; true; i++ )
        {
            if ( i % 2 == 0)
            {
                if ( n < gcd(a,n) ) {output.append("1\n");break;}
                else n -= gcd(a, n);
            }
            else
            {
                if ( n < gcd(b,n) ) {output.append("0\n");break;}
                else n -= gcd(b, n);
            }
        }
    }
    System.out.print(output);
}
}