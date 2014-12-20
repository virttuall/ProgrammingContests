package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_313A_IlyaandBankAccount {
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line1, lines[], line2, line;
    int n, data[], i1, i2;
    n = Integer.parseInt(in.readLine());
    if ( n >= 0)
    {
        System.out.println(n);
    }
    else
    {
        line = n + "";
        line1 = line.substring(0, line.length()-1);
        line2 = line.substring(0, line.length()-2) + line.substring(line.length()-1);
        i1 = Integer.parseInt(line1);
        i2 = Integer.parseInt(line2);
        if ( i1 > i2) System.out.println(i1);
        else System.out.println(i2);
    }
    System.out.print(out);
}
}