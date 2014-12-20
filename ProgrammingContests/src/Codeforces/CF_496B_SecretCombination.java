package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_496B_SecretCombination {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder("");
        int n = Integer.parseInt(in.readLine());
        int arr[] = new int[n], dif;
        String line = in.readLine();
        for ( int i = 0; i < n; i++ )
            arr[i] = Integer.parseInt(line.substring(i, i+1));
        String min = "";
        for ( int i = 0; i < n; i++ ) min += "9";
        for ( int i = 0; i < n; i++ )
        {
            
            dif = (10 - arr[i])%10;
            line = "0";
            for ( int j = 1; j  <n; j++ )
            {
                line += (""+((arr[(i+j)%n]+dif))%10); 
            }
            if ( line.compareTo(min) < 0)
                min = line;
        }
        System.out.println(min);
    }
}