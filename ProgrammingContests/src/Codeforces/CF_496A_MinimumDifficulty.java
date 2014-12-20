package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_496A_MinimumDifficulty {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder("");
        int n = Integer.parseInt(in.readLine());
        int arr[] = new int[n];
        String lines[] = in.readLine().split(" ");
        for ( int i = 0; i < n; i++ )
        {
            arr[i] = Integer.parseInt(lines[i]);
        }
        int dif;
        int max;
        int min = Integer.MAX_VALUE;
        for ( int i = 1; i < n-1; i++ )
        {
            max = Integer.MIN_VALUE;
            for ( int j = 0; j  < n-1; j++ )
            {
                if ( j == i ) continue;
                if ( j == i -1)
                {
                    dif = arr[j+2]-arr[j];
                }
                else
                {
                    dif = arr[j+1]-arr[j];
                }
                if ( dif > max) max = dif;
            }
            if ( max < min) min = max;
        }
        System.out.println(min);
    }
}