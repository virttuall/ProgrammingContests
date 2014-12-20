package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_476B_DreamoonandWiFi {
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
    public static int comb( int a, int b)
    {
        int d = 1;
        for ( int i = b+1; i <= a; i++ )
        {
            d *= i;
        }
        int n = 1;
        for ( int i = 1; i  <= (a-b); i++ )
        {
            n *= i;
        }
        return d/n;
    }
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String  lines[];
    char[] line1, line2;
    int nMas, nMenos, nInterogantes, estoy = 0, voy = 0, dif, nInte = 0;
    int n, data[];
    line1 = in.readLine().toCharArray();
    line2 = in.readLine().toCharArray();
    double r = 0;
    for ( int i = 0; i < line1.length; i++ )
    {
        if ( line1[i] == '+')
        {
            voy++;
        }
        else
        {
            voy--;
        }
        if ( line2[i] == '+')
        {
            estoy++;
        }
        else if ( line2[i] == '-')
        {
            estoy--;
        }
        else
        {
            nInte++;
        }   
    }
    dif = (int)Math.abs(estoy - voy);
    if ( nInte < dif)
    {
        r = 0;
    }
    else if ( nInte == 0)
    {
        if ( voy == estoy ) r = 1;
        else r = 0;
    }
    else
    {
        nMas = (nInte+dif) / 2;
        int d1 = comb(nInte, nInte-nMas);
        int d2 = 1 << nInte;
        r = ((double)d1)/((double)d2);
    }
    String res = String.format("%.12f %n", r);
    res = res.replaceAll(",", ".").trim();
    System.out.println(res);
}
}