package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
public class CF_297B_FishWeight{
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    Integer m, n, k, ms[], ns[], d, min;
    lines = input.readLine().split(" ");
    m = Integer.parseInt(lines[0]);
    n = Integer.parseInt(lines[1]);
    k = Integer.parseInt(lines[2]);
    boolean flag = false;
    lines = input.readLine().split(" ");
    ns = new Integer[n];
    ms = new Integer[m];
    for ( int i = 0;i < m; i++ )
    {
        ms[i] = Integer.parseInt(lines[i]);
    }
    lines = input.readLine().split(" ");
    for ( int i = 0; i < n; i++ )
    {
        ns[i] = Integer.parseInt(lines[i]);
    }
    Comparator<Integer> c = new Comparator<Integer>() {
        
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1*o1.compareTo(o2);
        }
    };
    Arrays.sort(ns, c);
    Arrays.sort(ms, c);
    min = m;
    if ( n < m) min = n;
    for ( int i = 0; i < min; i++ )
    {
        if ( ms[i] > ns[i] )
        {
            flag = true;
            break;
        }
    }
    if ( m > n) flag = true;
    if ( flag )
        System.out.println("YES");
    else
        System.out.println("NO");
    
}
}