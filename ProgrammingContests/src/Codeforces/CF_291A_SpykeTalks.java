package Codeforces;


import java.util.*;
import java.io.*;
public class CF_291A_SpykeTalks {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] se = input.readLine().split(" ");
        for( int i = 0; i < n; i++ )
        {
            if( Integer.parseInt(se[i]) == 0 ){continue;
            
            }
            else if( list.contains( Integer.parseInt(se[i]) )  )
            {
                count++;
            }
            else if(!list.contains(Integer.parseInt(se[i])))
            {
                list.add(Integer.parseInt(se[i]));
            }
        }
        int ax;
        for( int i = 0; i < n; i++ )
        {
            ax = 0;
            for( int j = 0; j <se.length; j++ )
            {
                if( i != j)
                {
                    
                    if( se[i].equals(se[j]) && !se[i].equals("0"))
                        ax++;
                }
            }
            if( ax > 1 ) 
            {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(count);
            
    }
}