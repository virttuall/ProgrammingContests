import java.util.*;
import java.math.*;
import java.io.*;

public class CF_7C_Line
{
    public static long[] gcd(long a, long b)
    {
        if ( b == 0 ) return new long[]{a, 1, 0};
        long v[] = gcd(b, a%b);
        return new long[]{ v[0], v[2], v[1] - (a/b)*v[2]};
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder("");
        long A, B, C, result[];
        String line, lines[];
        lines = in.readLine().trim().split("\\s+");
        A = Long.parseLong(lines[0]);
        B = Long.parseLong(lines[1]);
        C = Long.parseLong(lines[2])*-1l;
        result = gcd(A, B);
        if ( C % result[0] != 0 )
            System.out.println("-1");
        else 
            System.out.println((result[1]*(C/result[0])) +" "+(result[2]*(C/result[0])));
    }
}