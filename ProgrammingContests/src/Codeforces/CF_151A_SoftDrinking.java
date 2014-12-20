package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CF_151A_SoftDrinking {
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n, k , l, c , d, p, nl, np, bebidaT, comidaT, aux1, aux2 , aux3;
    while(true)
    {
        line = input.readLine();
        if ( line == null || line.equals("")) break;
        lines = line.split(" ");
        n = Integer.parseInt(lines[0]);
        k = Integer.parseInt(lines[1]);
        l = Integer.parseInt(lines[2]);
        c = Integer.parseInt(lines[3]);
        d = Integer.parseInt(lines[4]);
        p = Integer.parseInt(lines[5]);
        nl = Integer.parseInt(lines[6]);
        np = Integer.parseInt(lines[7]);
        bebidaT = k*l;
        comidaT = c*d;
        aux1 = bebidaT/(n*nl);
        aux2 = comidaT/n;
        aux3 = p/(n*np);
        output.append((int)Math.min(Math.min(aux1, aux2), aux3)+"\n");
    }
    System.out.print(output);
}
}