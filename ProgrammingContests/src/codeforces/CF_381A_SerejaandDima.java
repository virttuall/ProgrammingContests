package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CF_381A_SerejaandDima {
public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();
    String line, lines[];
    int n, aux1, aux2, count1, count2;
    ArrayList<String> list;
    while(true)
    {
        list = new ArrayList<String>();
        line = input.readLine();
        if ( line == null || line.equals("")) break;
        count1 = count2 = 0;
        n = Integer.parseInt(line);
        line = input.readLine();
        lines = line.split(" ");
        for(int i = 0; i < lines.length; i++ )
            list.add(lines[i]);
        for( int i = 0; i < lines.length; i++ )
        {
            if ( Integer.parseInt(list.get(0)) > Integer.parseInt(list.get(list.size()-1)) )
            {
                if ( i % 2 == 0 ) count1 += Integer.parseInt(list.get(0));
                else count2 += Integer.parseInt(list.get(0));
                list.remove(0);
            }
            else
            {
                if ( i % 2 == 0 ) count1 += Integer.parseInt(list.get(list.size()-1));
                else count2 += Integer.parseInt(list.get(list.size()-1));
                list.remove(list.size()-1);
            }
        }
        output.append(count1 + " "+ count2 + "\n");
    }
    System.out.print(output);
}
}