package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CF_230A_Dragons {
    private static Scanner in;
    static class Nodo implements Comparable<Nodo>
    {
        int a; int b;
        public Nodo( int a, int b)
        {
            this.a = a; 
            this.b = b;
        }
        
        @Override
        public int compareTo(Nodo o) {
            // TODO Auto-generated method stub
            return new Integer(a).compareTo(o.a);
        }
    }
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    in = new Scanner(System.in);
    int lines1[], lines2[];
    int s, n;
    boolean flag;
    Nodo array[];
    while(true)
    {
        line = input.readLine();
        flag = false;
        if ( line == null || line.equals("")) break;
        s = Integer.parseInt(line.split(" ")[0]);
        n = Integer.parseInt(line.split(" ")[1]);
    
        array = new Nodo[n];
        lines1 = new int[n]; lines2 = new int[n];
        for( int i = 0; i < n; i++ )
        {
            lines = input.readLine().split(" ");
            array[i] = new Nodo(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
        }
        Arrays.sort(array);
        for( int i = 0; i < n; i++ )
        {
            if ( s <= (int)array[i].a ) {flag = true;break;}
            else s += (int)array[i].b;
        }
        if ( flag) output.append("NO\n");
        else output.append("YES\n");
    }
    System.out.print(output);
}
}