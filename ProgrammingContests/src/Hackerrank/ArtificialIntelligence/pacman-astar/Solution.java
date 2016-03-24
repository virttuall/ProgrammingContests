import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int rp, cp, rf, cf, nr, nc, matrix[][], fathersRow[][], fathersCol[][];
    public static int xs[] = new int[]{0, 1, 0, -1}, ys[] = new int[]{-1, 0, 1, 0};  
    public static boolean visited[][];
    public static boolean isPosible( int row, int col)
    {
        if ( row >= 0 && row < nr && col >= 0 && col < nc ) return true;
        return false;
    }
    public static int h(int r, int c)
    {
        return Math.abs(r- rf)+Math.abs(c-cf);
    }
    public static class Node implements Comparable<Node>
    {
        int f, g, h, row, col, fRow, fCol;
        @Override
        public int compareTo(Node arg0)
        {
            return new Integer(f).compareTo(arg0.f);
        }
        public Node(int _row, int _col, int _g, int _h, int _fRow, int _fCol )
        {
            row = _row;
            col = _col;
            g = _g;
            h = _h;
            f = g+h;
            fRow = _fRow;
            fCol = _fCol;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder("");
        String line, lines[];
        char arrC[];
        Node nodeAux;
        int auxR, auxC;
        lines = in.readLine().split(" ");
        rp = Integer.parseInt(lines[0]);
        cp = Integer.parseInt(lines[1]);
        lines = in.readLine().split(" ");
        rf = Integer.parseInt(lines[0]);
        cf = Integer.parseInt(lines[1]);
        lines = in.readLine().split(" ");
        nr = Integer.parseInt(lines[0]);
        nc = Integer.parseInt(lines[1]);
        matrix = new int[nr][nc]; // space <- 0 , wall <- 1, food <- 2
        visited = new boolean[nr][nc];
        fathersRow = new int[nr][nc];
        fathersCol = new int[nr][nc];
        for( int i = 0; i < nr; i++ )
        {
        	arrC = in.readLine().toCharArray();
        	for( int j = 0; j < nc; j++ ) 
        	{
        		if ( arrC[j] == '-' || arrC[j] == 'P')
        		{
        			matrix[i][j] = 0;
        		}
        		else if ( arrC[j] == '%' )
        		{
        			matrix[i][j] = 1;
        		}
        		else
        		{
        			matrix[i][j] = 2;
        		}
        	}
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add( new Node(rp, cp, 0, h(rp, cp), -1, -1 ));
        while( !pq.isEmpty() )
        {
            nodeAux = pq.poll();
            if ( visited[nodeAux.row][nodeAux.col]) continue;
            fathersCol[nodeAux.row][nodeAux.col] = nodeAux.fCol;
            fathersRow[nodeAux.row][nodeAux.col] = nodeAux.fRow;
            if ( matrix[nodeAux.row][nodeAux.col] == 2)
            {
                break;
            }
            visited[nodeAux.row][nodeAux.col] = true;
            for ( int i = 0; i < 4; i++ )
            {
                auxR = nodeAux.row + ys[i];
                auxC = nodeAux.col + xs[i];
                if ( isPosible( auxR, auxC) )
                {
                    if ( matrix[auxR][auxC] != 1 )
                    {
                        pq.add( new Node( auxR, auxC, nodeAux.g+1, h(auxR, auxC), nodeAux.row, nodeAux.col));
                    }                    
                }
            }
        }
        int tempR, tempC;
        int count = 0;
        ArrayList<Integer> listRow = new ArrayList<Integer>(), listCol = new ArrayList<Integer>(); 
        while( true )
        {
            listCol.add(cf);
            listRow.add(rf);
            if ( rf == rp && cf == cp ) break;
            tempR = fathersRow[rf][cf];
            tempC = fathersCol[rf][cf];
            count++;
            rf = tempR;
            cf = tempC;
        }
        out.append(count+"\n");
        for( int i = listCol.size()-1; i >= 0; i-- ) out.append(listRow.get(i)+" "+listCol.get(i)+"\n");
        System.out.print(out);
    }
}