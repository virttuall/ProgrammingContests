package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_476A_DreamoonandStairs {
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
    int n, data[], m, min, max;
    lines = in.readLine().split(" ");
    n = Integer.parseInt(lines[0]);
    m = Integer.parseInt(lines[1]);
    if ( n == 0 )
    {
        System.out.println(0);
    }
    else
    {
        int i = 1;
        for ( ; i < 100000; i++ )
        {
            min = i*m;
            max = 2*i*m;
            if ( n <= max && n >= min )
            {
                System.out.println(i*m);
                break;
            }
            
        }
        if ( i == 100000 ) 
            System.out.println(-1);
    }
}
}