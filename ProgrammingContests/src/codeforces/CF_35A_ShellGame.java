package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;
public class CF_35A_ShellGame{
public static int x[];
public static void swap(int a, int b)
{
    int aux = x[a-1];
    x[a-1] = x[b-1];
    x[b-1] = aux;
}
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("input.txt"));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n;
    x = new int[3];
    line = input.readLine();
    n = Integer.parseInt(line);
    x[0] = x[1] = x[2] = 0;
    x[n-1] = 1;
    for ( int i = 0; i < 3; i++ )
    {
        lines = input.readLine().split(" ");
        swap(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));           
    }
    for ( int i = 0; i < 3; i++ )
    {
        if ( x[i] == 1)
            line = (i+1)+"";
    }
    FileWriter fichero = null;
    PrintWriter pw = null;
    try
    {
        fichero = new FileWriter("output.txt");
        pw = new PrintWriter(fichero);
        pw.println(line);

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
       try {
       // Nuevamente aprovechamos el finally para 
       // asegurarnos que se cierra el fichero.
       if (null != fichero)
          fichero.close();
       } catch (Exception e2) {
          e2.printStackTrace();
       }
    }
}
}