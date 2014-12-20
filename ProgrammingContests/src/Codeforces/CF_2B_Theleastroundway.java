package Codeforces;

import java.io.*;
import java.util.*;
import java.math.*;

public class CF_2B_Theleastroundway{
public static long count2s( long a )
{
    if ( a == 0) return 0;
    long count = 0;
    while( a % 2 == 0 && a > 0)
    {
        count++;
        a /= 2;
    }
    return count;
}
public static long count5s( long a)
{
    if ( a == 0) return 0;
    long count = 0;
    while( a % 5 == 0 && a > 0)
    {
        count++;
        a /= 5;
    }
    return count;
}
public static long min( long a, long b)
{
    if ( a  < b) return a;
    return b;
}
public static long max( long a, long b)
{
    if ( a > b) return a;
    return b;
}
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String  lines[];
    long matrix[][][], v, aux1, aux2,aux11, aux12, aux21, aux22,aux3, aux4;
    int n;
    boolean zeros = false;
    n = Integer.parseInt(in.readLine());
    matrix = new long[n][n][3];
    int indexiz = -1, indexjz = -1;
    for ( int i = 0;i < n; i++ )
    {
        lines = in.readLine().split(" ");
        for ( int j = 0; j < n; j++ )
        {
            v = Long.parseLong(lines[j]);
            matrix[i][j][0] = v;
            if ( v == 0) 
            {
                zeros = true;
                indexiz = i;
                indexjz = j;
            }
            
        } 
    }
    
    for ( int i = 0; i < n; i++ )
    {
        for ( int j = 0; j < n; j++ )
        {
            matrix[i][j][1] = count2s(matrix[i][j][0]);
            matrix[i][j][2] = count5s(matrix[i][j][0]);
        }
    }
    
    

    if ( zeros )
    {
        boolean flag = false;
        if ( matrix[0][0][0] == 0) 
        {
            matrix[0][0][1] = 1;
            matrix[0][0][2] = 1;
        }
        if ( matrix[0][0][0] % 2 == 0)  matrix[0][0][1] = 1;
        if ( matrix[0][0][0] % 5 == 0)  matrix[0][0][2] = 1;
        for ( int i = 1; i < n; i++ )
        {
            if ( matrix[0][i][0]  == 0 )
            {
                matrix[0][i][1] = 1;
                matrix[0][i][2] = 1;
            }
            if ( matrix[0][i][0] % 2 == 0 || matrix[0][i-1][1] == 1)  matrix[0][i][1] = 1;
            if ( matrix[0][i][0] % 5 == 0 || matrix[0][i-1][2] == 1)  matrix[0][i][2] = 1;
            
            
            
            if ( matrix[i][0][0]  == 0 )
            {
                matrix[i][0][1] = 1;
                matrix[i][0][2] = 1;
            }
            if ( matrix[i][0][0] % 2 == 0 || matrix[i-1][0][1] == 1)  matrix[i][0][1] = 1;
            if ( matrix[i][0][0] % 5 == 0 || matrix[i-1][0][2] == 1)  matrix[i][0][2] = 1;
        }
        for ( int i = 1; i < n; i++ )
        {
            for ( int j = 1; j < n; j++ )
            {
                if ( matrix[i][j][0] == 0 || matrix[i][j][0] % 2 == 0 || ( matrix[i-1][j][1] == 1 && matrix[i][j-1][1] == 1))
                    matrix[i][j][1] = 1;
                
                if ( matrix[i][j][0] == 0 || matrix[i][j][0] % 5 == 0 || ( matrix[i-1][j][2] == 1 && matrix[i][j-1][2] == 1))
                    matrix[i][j][2] = 1;
            }
        }
        if ( matrix[n-1][n-1][1] == 0 || matrix[n-1][n-1][2] == 0)
        {
            
            int indexi = n-1, indexj = n-1, p = -1;
            if ( matrix[n-1][n-1][1] == 0) p = 1;
            else p = 2;
            String res = "";
            while( !(indexi == 0 && indexj == 0)) 
            {
                if ( indexi == 0)
                {
                    res = "R"+res;
                    indexj--;
                }
                else if ( indexj == 0)
                {
                    res = "D"+res;
                    indexi--;
                }
                else if ( matrix[indexi][indexj-1][p] == 0 )
                {
                    res = "R"+res;
                    indexj--;
                }
                else
                {
                    res = "D"+res;
                    indexi--;
                }
            }
            System.out.println("0");
            System.out.println(res);
        }
        else
        {
            String res = "";
            for ( int i = 0; i < indexiz; i++ )
            {
                res += "D";
            }
            for ( int i = 0; i  < n-1; i++ )
            {
                res += "R";
            }
            for( int i = indexiz; i < n-1; i++ )
            {
                res += "D";
            }
            System.out.println("1");
            System.out.println(res);
        }
    }
    else
    {
        for ( int i = 1; i < n; i++ )
        {
            matrix[i][0][1] += matrix[i-1][0][1];
            matrix[0][i][1] += matrix[0][i-1][1];
            matrix[i][0][2] += matrix[i-1][0][2];
            matrix[0][i][2] += matrix[0][i-1][2];
        }
        
        for ( int i = 1; i < n; i++ )
        {
            for ( int j = 1 ; j < n; j++ )
            {
                matrix[i][j][1] += min(matrix[i-1][j][1], matrix[i][j-1][1]);
                matrix[i][j][2] += min(matrix[i-1][j][2], matrix[i][j-1][2]);
            }
        }

        
        
        int indexi = n-1, indexj = n-1, p = -1;
        if ( matrix[n-1][n-1][1] < matrix[n-1][n-1][2]) p = 1;
        else p = 2;
        String res = "";
        while( !(indexi == 0 && indexj == 0)) 
        {
            if ( indexi == 0)
            {
                res = "R"+res;
                indexj--;
            }
            else if ( indexj == 0)
            {
                res = "D"+res;
                indexi--;
            }
            else if ( matrix[indexi][indexj-1][p] < matrix[indexi-1][indexj][p])
            {
                res = "R"+res;
                indexj--;
            }
            else
            {
                res = "D"+res;
                indexi--;
            }
        }
        System.out.println(min( matrix[n-1][n-1][1], matrix[n-1][n-1][2]));
        System.out.println(res);
        
    }
}
}