package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_454A_LittlePonyandCrystalMine {
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
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n = Integer.parseInt(input.readLine()), x= 0, y= 0;
    for ( int i = 0; i < n; i++ )
    {
        if ( i < n/2 ) { x= n/2 - i; y = n/2 + i; }
        if ( i == n/2 ) { x = 0; y = n-1; }
        if ( i > n/2 ) { x = i - n/2; y = n - x-1; }
        for ( int j = 0; j < n; j++ )
        {
            if ( j >= x && j <= y )
            {
                  output.append("D");
            }
            else
                output.append("*");
        }
        output.append("\n");
    }
    System.out.print(output);
}
}