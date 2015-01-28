package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CF_289D_PolothePenguinandHouses {
public static int l[], length;
public static boolean isCycle()
{
    int value;
    for ( int i = 0; i < length; i++ )
    {
        value = l[i]-1;
        for ( int j = 0; j < 7; j++ )
        {
            if ( value != -1 )
            {
                value = l[value]-1;
            }
            else
            {
                break;
            }
        }
        if ( value == -1) continue;
        return false;
    }
    return true;
}
public static int countCycles()
{

    if ( length <= 1) return 1;
    if ( length == 2 ) return 3;
    l = new int[7];
    int t[] = new int[7];
    int count = 0;
    for( int i = 0; i < length; i++ )
        t[i] = length;
    for ( int p1 = 0; p1 <= t[0]; p1++ ) if ( p1 != 1)
    for ( int p2 = 0; p2 <= t[1]; p2++ ) if ( p2 != 2)
    for ( int p3 = 0; p3 <= t[2]; p3++ ) if ( p3 != 3)
    for ( int p4 = 0; p4 <= t[3]; p4++ ) if ( p4 != 4)
    for ( int p5 = 0; p5 <= t[4]; p5++ ) if ( p5 != 5)
    for ( int p6 = 0; p6 <= t[5]; p6++ ) if ( p6 != 6)
    for ( int p7 = 0; p7 <= t[6]; p7++ ) if ( p7 != 7)
    {
        l[0] = p1;
        l[1] = p2;
        l[2] = p3;
        l[3] = p4;
        l[4] = p5;
        l[5] = p6;
        l[6] = p7;
        if ( isCycle()) count++; 
    }
    return count;
}
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n, k;
    lines = input.readLine().split(" ");
    n = Integer.parseInt(lines[0]);
    k = Integer.parseInt(lines[1]);
    length = k-1;
    BigInteger bk = new BigInteger(k+""), bnk = new BigInteger((n-k)+""), m = new BigInteger("1000000007");
    bnk = bnk.modPow(bnk, m);
    bk = bk.multiply(new BigInteger(countCycles()+""));
    System.out.println(bk.multiply(bnk).mod(m).toString());
} 
}