package codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_336A_VasilytheBearandTriangle {
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("n");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line, lines[];
    int n, data[], x, y;
    lines = in.readLine().split(" ");
    x = Integer.parseInt(lines[0]);
    y = Integer.parseInt(lines[1]);
    if ( x < 0 && y < 0 )
    {
        System.out.println((x+y)+" 0 0 "+(x+y));
    }
    else if ( x < 0 && y > 0)
    {
        System.out.println((-1*(-x+y))+" 0 0 "+((-x+y)));
    }
    else if ( x > 0 && y < 0 )
    {
        System.out.println("0 "+(y-x)+" "+(x-y)+" 0");
    }
    else
    {
        System.out.println("0 "+(x+y)+" "+(x+y)+" 0");
    }
}
}