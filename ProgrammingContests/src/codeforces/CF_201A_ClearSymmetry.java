import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_201A_ClearSymmetry {
    public static class Node implements Comparable<Node>
    {
        int value;
        int iteration;
        int centros;
        public Node(int value, int interation, int centros)
        {
            this.value = value;
            this.iteration = interation;
            this.centros = centros;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return new Integer(iteration).compareTo(o.iteration);
        }
        
    }
public static void main(String[] args) throws IOException {
    BufferedReader in;
    StringBuilder out = new StringBuilder();
    File file = new File("inpu.txt");
    if (file.exists())
        in = new BufferedReader(new FileReader(file));
    else
        in = new BufferedReader(new InputStreamReader(System.in));
    String line, lines[];
    PriorityQueue<Node> p = new PriorityQueue<Node>();
    
    p.add(new Node(0, 0, 0));
    p.add(new Node(1, 0, 1));
    p.add(new Node(3, 2, 1));
    int av, ai;
    Node aux;
    boolean visited[] = new boolean[101];
    int sizes[] = new int[101];
    int iter;
    int cap;
    while(!p.isEmpty())
    {
        aux = p.poll();
        if ( aux.value > 100 ) continue;
        if ( visited[aux.value] ) continue;
        visited[aux.value] = true;
        sizes[aux.value] = 2*aux.iteration+1;
        iter = aux.iteration+1;
        cap = iter*4;
        int vv = 0;
        while( vv <= cap )
        {
            p.add(new Node(vv+aux.value, iter, 0));
            vv+=4;
        }
        if ( aux.centros == 0)
        {
            vv = 2;
            while( vv <= cap )
            {
                p.add(new Node(vv+aux.value, iter, 1));
                vv+=4;
            }   
        }
        
    }
    //int n = Integer.parseInt(in.readLine());
    //System.out.println("hola "+n);
    System.out.println(sizes[Integer.parseInt(in.readLine())]);
}
}