package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_337B_RoutineProblem{
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line, lines[];
    double n, data[],a , b, c, d;
    long numerator, denominator;
    lines = in.readLine().split(" ");
    a = Double.parseDouble(lines[0]);
    b = Double.parseDouble(lines[1]);
    c = Double.parseDouble(lines[2]);
    d = Double.parseDouble(lines[3]);
    BigInteger num, den, bb;
    if ( a / c < b / d)
    {
        numerator = (long)(c*c*a*b - c*d*a*a);
        denominator = (long)(a*b*c*c);
    }
    else
    {
        numerator = (long)(d*d*a*b - c*d*b*b);
        denominator = (long)(a*b*d*d);
    }
    num = new BigInteger(numerator+"");
    den = new BigInteger(denominator+"");
    bb = num.gcd(den);
    num = num.divide(bb);
    den = den.divide(bb);
    System.out.println(num.toString()+"/"+den.toString());
}
}