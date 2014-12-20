package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_3A_Shortestpathoftheking {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String cadena1,cadena2;
        String auxiliar1 = "", auxiliar2 = "";
        cadena1 = input.readLine();
        cadena2 = input.readLine();
        int x = cadena1.charAt(0)-cadena2.charAt(0);
        int y = cadena1.charAt(1)-cadena2.charAt(1);
        if (x < 0)
        {
            x = x*-1;
            for ( int i = 0; i < x; i++ )
                auxiliar1 += "R";
        }
        else
        {
            for ( int i = 0; i < x; i++ )
                auxiliar1 += "L";
        }
        if ( y < 0 )
        {
            y = y*-1;
            for ( int i = 0; i < y; i++ )
                auxiliar2 += "U";
        }
        else
        {
            for ( int i = 0; i < y; i++ )
                auxiliar2 += "D"; 
        }
        int menor = Math.min(auxiliar1.length(), auxiliar2.length());
        int maximo = Math.max(auxiliar1.length(), auxiliar2.length());
        System.out.println(maximo);
        for ( int i = 0; i < menor; i++ )
            System.out.println(auxiliar1.substring(i, i+1) +auxiliar2.substring(i, i+1));
        for ( int i = menor; i< maximo; i++  )
        {
            if ( auxiliar1.length() < auxiliar2.length() )
                    System.out.println(auxiliar2.substring(i, i+1));
            else
                System.out.println(auxiliar1.substring(i, i+1));
            
        }
        
    }
}