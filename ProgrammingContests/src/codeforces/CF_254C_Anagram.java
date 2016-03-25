import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class CF_254C_Anagram {
    public static int[] parseInt(String line)
    {
        String lines[] = line.split(" ");
        int result[] = new int[lines.length];
        for( int i = 0; i < lines.length; i++ )
        {
            result[i] = Integer.parseInt(lines[i]);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        StringBuilder out = new StringBuilder();
        File file = new File("input.txt");
        if (file.exists())
            in = new BufferedReader(new FileReader(file));
        else
            in = new BufferedReader(new InputStreamReader(System.in));
        File fileS = new File("output.txt");
        PrintWriter salida= new PrintWriter(fileS);
        String line, lines[];
        char arrI[] = in.readLine().toCharArray();
        char arrO[] = in.readLine().toCharArray();
        int countI[] = new int[26];
        int countO[] = new int[26];
        for( int i = 0; i < arrI.length; i++ ) countI[arrI[i]-'A']++;
        for( int i = 0; i < arrI.length; i++ ) countO[arrO[i]-'A']++;
        int nec[] = new int[26];
        Queue<Character> list = new LinkedList<Character>();
        for( int i = 0; i < 26; i++ )
        {
            nec[i] = countO[i]-countI[i];
        }
        //System.out.println(Arrays.toString(nec));
        for( int i = 0; i<  26; i++ )
        {
            for( int j = 0; j < nec[i]; j++)
            {
                list.add((char)('A'+i));
                //System.out.println((char)('A'+i));
            }
        }
        
        char result[] = new char[arrI.length];
        int index = 0;
        int countV = 0;
        for(int i = 0; i < arrI.length; i++ )
        {
            if ( nec[arrI[i]-'A'] < 0 )
            {
                if ( list.peek() < arrI[i] )
                {
                    //System.out.println("index querer "+i);
                    result[i] = list.poll();
                    nec[arrI[i]-'A']++;
                    countV++;
                    //change
                    
                }
                else if( countI[arrI[i]-'A'] == -1*(nec[arrI[i]-'A']))
                {
                    //System.out.println("index obliado "+i);
                    countV++;
                    result[i] = list.poll();
                    nec[arrI[i]-'A']++;
                }
                else
                {
                    result[i] = arrI[i];
                    
                }
            }
            else
            {
                    result[i] = arrI[i];
            }
            countI[arrI[i]-'A']--;
        }
        //System.out.println(countV);
        //System.out.println(new String(result));
        salida.print(countV+"\n"+(new String(result))+"\n");
        salida.close();
        //System.out.println(Arrays.toString(nec));
        
        //System.out.print(out);
    }
}