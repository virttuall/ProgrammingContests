package codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_94A_RestoringPassword {
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
    line = in.readLine();
    Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
    for ( int  i = 0; i < 10; i++ )
    {
        hash.put(in.readLine(), i);
    }
    for ( int i = 0;i < 8; i++ )
    {
        //System.out.println(line.substring(10*i, 10*i+10));
        System.out.print(hash.get(line.substring(10*i, 10*i+10)));
    }
    System.out.print("\n");
}
}