package Codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_447C_DZY_LovesSequences {
    public static int n, data[], max, aux1, aux2,aux3, aux4, auxMax;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(
                System.in));
        StringBuilder output = new StringBuilder();
        String line, lines[];
        n = Integer.parseInt(input.readLine());
        lines = input.readLine().split(" ");
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(lines[i]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for ( int i = 1; i < n; i++ )
        {
            if ( data[i-1] >= data[i]) list.add(i);
        }
        list.add(n);
        line = "";
        max = Integer.MIN_VALUE;
        if ( list.size() == 2) max = n;
        for ( int i = 1; i < list.size()-1; i++)
        {
            aux1 = list.get(i-1);
            aux2 = list.get(i);
            aux3 = list.get(i+1);
            if ( aux2 +1 == aux3)
            {
                if ( aux3 != n)
                {
                    aux4 = list.get(2);
                    if ( data[aux2 - 1] + 1< data[aux2+1])
                    {
                        auxMax = aux4 - aux1;
                        if ( auxMax > max) { max = auxMax; line = "1 line"; }
                    }
                    else
                    {
                        auxMax = (aux2 - aux1 > aux4 - aux3) ? aux2 - aux1: aux4-aux3;
                        auxMax++;
                        if ( auxMax > max ) {max = auxMax;  line = "2 line"; }
                    }
                }
                else
                {
                    auxMax = aux2 - aux1;
                    auxMax++;
                    if ( auxMax > max) { max = auxMax; line = "3 line"; }
                }
            }
            else
            {
                if ( aux2 != 1 && (data[aux2-2]+1 < data[aux2] || data[aux2-1] +1< data[aux2+1]))
                { 
                    auxMax = aux3 - aux1; 
                    if ( auxMax > max) 
                    { 
                        max = auxMax; 
                        line = "4 line";
                    } 
                }
                else {auxMax = ( aux2-aux1 > aux3 - aux2) ? aux2 - aux1:  aux3 - aux2; auxMax++; if ( auxMax > max) { max = auxMax; line = "5 line";}}
                
            }
        }
        if ( n == 1) System.out.println(1);
        else System.out.println(max);
        
    }
}