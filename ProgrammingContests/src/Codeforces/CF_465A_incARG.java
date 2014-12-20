package Codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_465A_incARG {
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
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line1, line2, lines[];
    int n, data[], n1, n2;
    n = Integer.parseInt(in.readLine());
    line1 = in.readLine();
    String r = "";
    String car = "1";
    for ( int i = 0; i < n; i++ )
    {
        if ( line1.substring(i, i+1).equals("1") && car.equals("1"))
        {
            r += "0";
            car = "1";
        }
        else if ( line1.substring(i, i+1).equals("1") && car.equals("0"))
        {
            r += "1";
            car = "0";
        }
        else if ( line1.substring(i, i+1).equals("0") && car.equals("1"))
        {
            r += "1";
            car ="0";
        }
        else
        {
            r+= "0";
        }
    } 
    int count = 0;
    for( int i = 0; i < n; i++ )
    {
        if ( !r.substring(i, i+1).equals(line1.substring(i, i+1))) count++;
    }
    System.out.print(count);
}
}