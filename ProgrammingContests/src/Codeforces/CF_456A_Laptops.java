package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;


public class CF_456A_Laptops {
public static int[] parseI(String line) {
    String lines[] = line.split(" ");
    int r[] = new int[lines.length];
    for (int i = 0; i < r.length; i++) {
        r[i] = Integer.parseInt(lines[i]);
    }
    return r;
}

public static long[] parseL(String line) {
    String lines[] = line.split(" ");
    long r[] = new long[lines.length];
    for (int i = 0; i < r.length; i++) {
        r[i] = Long.parseLong(lines[i]);
    }
    return r;
}

public static double[] parseD(String line) {
    String lines[] = line.split(" ");
    double r[] = new double[lines.length];
    for (int i = 0; i < r.length; i++) {
        r[i] = Double.parseDouble(lines[i]);
    }
    return r;
}
public static class Laptop implements Comparable<Laptop>
{
    int p, q;
    public Laptop( int p, int q)
    {
        this.p = p;
        this.q = q;
    }
    @Override
    public int compareTo(Laptop o) {
        // TODO Auto-generated method stub
        return new Integer(p).compareTo(o.p);
    }
    
}
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n, data[][];
    Laptop laptops[];
    
    // code
    
    n = Integer.parseInt(input.readLine());
    laptops = new Laptop[n];
    for ( int i = 0; i < n; i++ )
    {
        lines = input.readLine().split(" ");
        laptops[i] = new Laptop(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
    }
    Arrays.sort(laptops);
    boolean flag = true;
    
    for ( int i = 1; i < n; i++ )
    {
        if ( laptops[i].p > laptops[i-1].p && laptops[i].q < laptops[i-1].q )
        {
            flag = false;
        }
    }
    if ( flag ) System.out.println("Poor Alex");
    else System.out.println("Happy Alex");
}
}