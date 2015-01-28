package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_384A_Coder {
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        int n, aux1, aux2;
        StringBuilder salida = new StringBuilder();
        while(true)
        {
            entrada=input.readLine();
            if( entrada == null   || entrada.equals("")) break;
            n = Integer.parseInt(entrada);
            if ( n % 2 == 0) 
            {
                salida.append((n*n/2)+"\n");
            }
            else
            {
                aux1 = n/2;
                aux2 = aux1+1;
                salida.append((aux1*aux1+aux2*aux2)+"\n");
            }
            for( int i = 0; i < n; i++ )
                {
                    for( int j = 0; j < n; j++ )
                    {
                        if ( (i + j)%2 == 0) salida.append("C");
                        else salida.append(".");
                    }
                    salida.append("\n");
                }
                
        
        }
        System.out.print(salida);
    }
}