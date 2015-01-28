package codeforces;


import java.io.*;
import java.util.*;
import java.math.*;
public class CF_129B_StudentsandShoelaces{
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int count, G[][], nodes, edges, x, y, aux;
    ArrayList<Integer> ones;
    lines = input.readLine().split(" ");
    nodes = Integer.parseInt(lines[0]);
    edges = Integer.parseInt(lines[1]);
    G = new int[nodes+1][nodes+1];
    for (int i = 0; i < edges; i++) {
        lines = input.readLine().split(" ");
        x = Integer.parseInt(lines[0]);
        y = Integer.parseInt(lines[1]);
        G[x][y] = 1;
        G[y][x] = 1;
    }
    
    ones = new ArrayList<Integer>();
    int r = 0;
    do
    {
        for (Integer i : ones) {
            for ( int j = 1; j <= nodes; j++ )
            {
                if ( G[i][j] == 1)
                {
                    G[i][j] = 0;
                    G[j][i] = 0;
                    break;
                }
            }
        }
        ones = new ArrayList<Integer>();
        for ( int i = 1; i <= nodes; i++  )
        {
            aux = 0;
            for ( int j = 1; j <= nodes; j++ )
            {
                if ( G[i][j] == 1)
                {
                    aux++;
                }
            }
            if ( aux == 1)
                ones.add(i);
        }
                
        r++;
    }while( !ones.isEmpty());
    System.out.println(r-1);
}
}