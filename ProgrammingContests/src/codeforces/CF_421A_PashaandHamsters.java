package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_421A_PashaandHamsters{
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
    int n, data[],a , b, as[], bs[];
    lines = in.readLine().split(" ");
    n = Integer.parseInt(lines[0]);
    data = new int[n+1];
    as = parseI(in.readLine());
    bs = parseI(in.readLine());
    for ( int i = 0; i < as.length; i++ )
        data[as[i]] = 1;
    String r = "";
    for ( int i = 1; i <= n; i++ )
        if ( data[i] == 1) 
            r += "1 ";
        else
            r += "2 ";
    System.out.print(r.trim());
}
}