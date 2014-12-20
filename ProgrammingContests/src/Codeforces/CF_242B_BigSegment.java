package Codeforces;

import java.io.*;
import java.util.*;
import java.math.*;

public class CF_242B_BigSegment {
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
    String line, lines[];
    int n, data[], datax[], datay[];
    n = Integer.parseInt(in.readLine());
    datay = new int[n];
    datax = new int[n];
    for ( int tt = 0; tt < n; tt++)
    {
        lines = in.readLine().split(" ");
        datax[tt] = Integer.parseInt(lines[0]);
        datay[tt] = Integer.parseInt(lines[1]);
    }
    int min, max;
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    
    for ( int i = 0;i < n; i++ )
    {
        if ( datax[i] < min) {min = datax[i]; }
        if ( datay[i] > max) {max = datay[i]; }
    }
    int index1 = -1, index2 = -1;
    for ( int i = 0; i < n; i++ )
    {
        if ( datax[i] == min && datay[i] == max )
        {
            index1 = i+1;
            break;
        }
    }
    System.out.println(index1);
}
}