package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_361A_LevkoandTable {
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        int aux, suma, n;
        StringBuilder salida = new StringBuilder();
        while(true)
        {
            entrada=input.readLine();
            if( entrada == null   || entrada.equals("")) break;
            n = Integer.parseInt(entrada.split(" ")[0]);
            suma = Integer.parseInt(entrada.split(" ")[1]);
            int[][] matrix = new int[n][n];
            aux = suma - n +1;
            for( int i = 0; i < n; i++ )
                for( int j = 0; j < n; j++ )
                    if ( i == j ) matrix[i][j] = aux;
                    else matrix[i][j] = 1;
            for( int i = 0; i < n; i++ )
            {
                for(int j = 0; j < n; j++ )
                {
                    salida.append(matrix[i][j]);
                    if ( j != n-1) salida.append(" ");
                }
                salida.append("\n");
            }
        
        }
        System.out.print(salida);
    }
}