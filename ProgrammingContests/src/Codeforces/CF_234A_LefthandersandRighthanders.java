package Codeforces;


import java.io.*;

public class CF_234A_LefthandersandRighthanders {
    public static String salida( char a, char b, int aa, int bb)
    {
        if ( a == 'R' && b == 'L' )return (bb+1)+" "+(aa+1);
        return (1+aa) + " " + (1+bb);
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader input = new BufferedReader(new FileReader(new File("input.txt")));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter( new File("output.txt"))));
        int n = Integer.parseInt(input.readLine());
        String line = input.readLine();
        int aux,estoy;
        
        if( n % 4 == 0) 
        {
            aux = n/4;
            for( int i = 0; i < aux; i++ )
            {
                output.println(salida(line.charAt(i*4),line.charAt(i*4+2), i*4 , i*4+2));
                output.println(salida(line.charAt(i*4+1),line.charAt(i*4+3), i*4+1 , i*4+3));
            }
        }
        else
        {
            aux = (n-6)/4;
            for( int i = 0; i < aux; i++ )
            {
                output.println(salida(line.charAt(i*4),line.charAt(i*4+2), i*4 , i*4+2));
                output.println(salida(line.charAt(i*4+1),line.charAt(i*4+3), i*4+1 , i*4+3));
            }
            estoy = aux*4;
            output.println(salida(line.charAt(estoy),line.charAt(estoy+2), estoy , estoy+2));
            output.println(salida(line.charAt(estoy+1),line.charAt(estoy+4), estoy+1 , estoy+4));
            output.println(salida(line.charAt(estoy+3),line.charAt(estoy+5), estoy+3 , estoy+5));
        }
        output.close();
    }
}