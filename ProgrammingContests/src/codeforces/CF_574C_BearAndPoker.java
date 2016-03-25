import java.io.*;
import java.math.*;
import java.util.*;

public class CF_574C_BearAndPoker
{
    public static int f(int value)
    {
        while( value % 2 == 0) value /= 2;
        while( value % 3 == 0) value /= 3;
        return value;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String lines[], line;
        lines = in.readLine().split(" ");
        int value = f(Integer.parseInt(lines[0]));
        boolean flag = true;
        for( int i = 1; i < n; i++ )
        {
            if ( value != f(Integer.parseInt(lines[i])))
            {
                flag = false;
                break;
            }
        }
        if ( flag ) System.out.println("Yes");
        else System.out.println("No");
    }
}