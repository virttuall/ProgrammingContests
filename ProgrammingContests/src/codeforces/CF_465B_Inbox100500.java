package codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_465B_Inbox100500 {
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
    int n, data[];
    n = Integer.parseInt(in.readLine());
    int count = 0;
    String l = in.readLine().replaceAll(" ", "");
    if ( !l.contains("1"))
    {
        System.out.println(0);
    }
    else
    {
        int estoy = l.indexOf("1"), index;
        count++;
        l = l.substring(estoy+1);
        while( (index = l.indexOf("1")) != -1)
        {
            if ( l.substring(0, 1).equals("0"))
            {
                count++;
                l = l.substring(index+1);
                count++;
            }
            else
            {
                count++;
                l = l.substring(1);
            }
        }
        System.out.print(count);
    }
}
}