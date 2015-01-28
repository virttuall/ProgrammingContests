package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_462C_ApplemanandToastman{
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
    long n, data[],sum = 0; 
    n = Long.parseLong(in.readLine());
    data = parseL(in.readLine());
    Arrays.sort(data);
    for ( int i = 0; i < n-1; i++ )
    {
        sum += (2+(long)i)*data[i];
    }
    sum += data[(int)n-1]*n;
    System.out.println(sum);
}
}