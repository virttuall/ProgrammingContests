import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_558C_AmrAndChemistry {
    public static int pesos[] = new int[100002];
    public static int elementos[] = new int[100002];
    public static void fUp( int i )
    {
        if ( 2*i+1 <= 100001 )
        {
            fUp( i*2 );
            fUp( i*2 +1 );
            
            pesos[i] += pesos[i*2]+elementos[i*2];
            pesos[i] += pesos[i*2+1]+elementos[i*2+1];
            elementos[i] += elementos[i*2] + elementos[i*2+1];
        }
        
    }
    
    public static void fDown( int i)
    {
        if ( i == (i/2)*2 )
        {
            int e = elementos[i/2]-elementos[i];
            int p = pesos[i/2]-pesos[i]-elementos[i];
            pesos[i] += p+e;
            elementos[i] += e;
        }
        if ( 2*i+1 <= 100001 )
        {
            fDown( i*2 );
            fDown( i*2 +1 );
        }
    }
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("in");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line, lines[];
    int n;
    int arr[];
    n = Integer.parseInt(in.readLine());
    arr = new int[n];
    lines = in.readLine().split(" ");
    
    for ( int i = 0; i < n; i++ )
    {
        arr[i] = Integer.parseInt(lines[i]);
        elementos[arr[i]]++;
    }
    int a = arr[0];
    boolean flag = false;
    for ( int i = 1; i < arr.length; i++ )
    {
        if ( a != arr[i] )
            flag = true;
    }
//  System.out.println(flag);
//  for ( int  i = 1; i <= 10; i++ )
//  {
//      System.out.println(i+" "+elementos[i]+" "+pesos[i]);
//  }
//  System.out.println();
    if ( flag )
    {
        fUp(1);
        fDown(2);
        fDown(3);
        int min = Integer.MAX_VALUE;
//      for ( int  i = 1; i <= 10; i++ )
//      {
//          System.out.println(i+" "+elementos[i]+" "+pesos[i]);
//      }
        for ( int i = 1; i <= 100000; i++ )
        {
            if ( pesos[i] != 0 && elementos[i] == n)
                min = Math.min(min, pesos[i]);
        }
        System.out.println(min);
    }
    else
    {
        System.out.println(0);
    }
}
}