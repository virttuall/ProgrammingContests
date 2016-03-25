import java.io.*;
import java.math.*;
import java.util.*;

public class CF_580C_KefaAndPark
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder("");
        String line, lines[];
        int n, m, x, y;
        boolean flags[];
        lines = in.readLine().trim().split("\\s+");
        n = Integer.parseInt(lines[0]);
        m = Integer.parseInt(lines[1]);
        lines = in.readLine().trim().split("\\s+");
        flags = new boolean[n];
        ArrayList<Integer> graph[] = new ArrayList[n];
        for( int i = 0; i < n; i++ ) graph[i] = new ArrayList<Integer>();
        for( int i = 0; i<  n; i++ )
        {
            if ( lines[i].equals("1") ) flags[i] = true;
        }
        for( int i = 0; i < n-1; i++ )
        {
            lines = in.readLine().trim().split("\\s+");
            x = Integer.parseInt(lines[0])-1;
            y = Integer.parseInt(lines[1])-1;
            graph[x].add(y);
            graph[y].add(x);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> cats = new LinkedList<Integer>();
        boolean visited[] = new boolean[n];
        q.add(0);
        cats.add(0);
        int node, cat;
        int count = 0;
        while( !q.isEmpty())
        {
            node = q.poll();
            cat = cats.poll();
            //System.out.println(node+" "+cat);
            if ( visited[node] ) continue;
            if ( flags[node] ) cat++;
            else cat = 0;
            visited[node] = true;
            if ( cat > m ) continue; 
            if ( graph[node].size() == 1 && node != 0) count++;
            for( int i = 0; i < graph[node].size(); i++ )
            {
                q.add(graph[node].get(i));
                cats.add( cat );
            }
        }
        System.out.println(count);
    }
}