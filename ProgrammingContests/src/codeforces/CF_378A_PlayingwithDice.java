package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF_378A_PlayingwithDice {
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line;
    int a, b, g, e, p;
    while(true)
    {
        line = input.readLine();
        if ( line == null || line.equals("")) break;
        a = Integer.parseInt(line.split(" ")[0]);
        b = Integer.parseInt(line.split(" ")[1]);
        g = e = p = 0;
        for( int j = 1; j <= 6; j++ )
        {
            if ( Math.abs(j-a) < Math.abs(j-b)) g++;
            else if (Math.abs(j-a) > Math.abs(j-b)) p++;
            else e++;
        }
        output.append(g+" "+e+" "+p);
    }
    System.out.print(output);
}
}