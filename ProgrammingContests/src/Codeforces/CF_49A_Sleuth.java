package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_49A_Sleuth{
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
    char c;
    line = in.readLine();
    line = line.replaceAll(" ", "").toLowerCase();
    line = line.substring(0, line.length()-1);
    c = line.charAt(line.length()-1);
    if ( c == 'y' || c == 'a' || c== 'e' || c == 'i' || c == 'o' || c == 'u')
        System.out.println("YES");
    else
        System.out.println("NO");
}
}