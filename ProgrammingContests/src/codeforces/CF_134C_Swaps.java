package codeforces;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_134C_Swaps {
    public static int[] parseInts(String line) {
        String lines[] = line.split(" ");
        int n = lines.length;
        int r[] = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = Integer.parseInt(lines[i]);
        }
        return r;
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
    int n, s;
    lines = in.readLine().split(" ");
    n = Integer.parseInt(lines[0]);
    s = Integer.parseInt(lines[1]);
    Queue arr[] = new Queue[s+1];
    int ar[] = parseInts(in.readLine());
    for( int i= 0; i < arr.length; i++ ) arr[i] = new LinkedList<Integer>();
    for ( int i = 0; i < ar.length; i++ )
    {
        arr[ar[i]].add(i+1);
    }
    int count = 0;
    int en,en2, auxE;
    int l;
    Queue<Integer> auxList;
    Queue<Integer> list1;
    Queue<Integer> list2;
    boolean flag = false;
    cc: for ( int i = s; i > 0; i-- )
    {
        while ( arr[i].size() > 0)
        {
            en = (Integer)arr[i].poll();
            auxList = new LinkedList<Integer>();
            list1 = new LinkedList<Integer>();
            list2 = new LinkedList<Integer>();
            l = i - arr[i].size();
            int ll = arr[i].size();
            for ( int j = 0; j  < ll && j < i; j++)
            {
                auxE = (Integer)arr[i].poll();
                auxList.add(auxE);
                count++;
                out.append(en+" "+auxE+"\n");
            }
            for( int j = 1, k = 1; j <= l;k++)
            {
                if ( i-k == 0)
                {
                    flag = true;
                    break cc;
                }
                while ( arr[i-k].size() > 0 && j <= l)
                {
                    en2 = (Integer)arr[i-k].poll();
                    j++;
                    list1.add(i-k-1);
                    list2.add(en2);
                    //arr[i-k-1].add(en2);
                    count++;
                    out.append(en+" "+en2+"\n");
                }
                
                
            }
            int cc = list1.size();
            for ( int ttt = 0; ttt < cc; ttt++ )
            {
                arr[list1.poll()].add(list2.poll());
            }
            arr[i-1].addAll(auxList);
            
        }
    }
    if (flag) System.out.print("No\n"); 
    else 
    {
        System.out.print("Yes\n"+count+"\n");
        System.out.print(out);
    }
}
}