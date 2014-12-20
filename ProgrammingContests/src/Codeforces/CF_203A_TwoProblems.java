package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_203A_TwoProblems {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int x, t, a ,b, ta, tb,max,min;
        String[] valores = input.readLine().split(" ");
        x = Integer.parseInt(valores[0]);
        t = Integer.parseInt(valores[1]);
        a = Integer.parseInt(valores[2]);
        b = Integer.parseInt(valores[3]);
        ta = Integer.parseInt(valores[4]);
        tb = Integer.parseInt(valores[5]);
        for( int i = 0; i < t; i++ )
        {
            for( int j = 0; j < t; j++ )
                if( x == (a-ta*j)+(b-tb*i))
                {
                    System.out.println("YES");
                    return;
                }
        }
        for( int i = 0; i < t; i++ )
            if( x == (a-ta*i) )
            {
                System.out.println("YES");
                return;
            }
        for( int i = 0; i < t; i++ )
            if( x == (b-tb*i) )
            {
                System.out.println("YES");
                return;
            }
        if( x == 0) System.out.println("YES");
        else System.out.println("NO");
        
    }
}