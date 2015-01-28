package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class CF_315B_SerejaandArray {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int n = Integer.parseInt(line.split(" ")[0]) , m = Integer.parseInt(line.split(" ")[1]);
        String[] arr = input.readLine().split(" ");
        int[] arrInt = new int[n];
        for( int i = 0; i < n; i++ )
        {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        int aux1, aux2, aux3 = 0;
        int aumento = 0;
        for( int i = 0; i < m; i++)
        {
            arr = input.readLine().split(" ");
            if ( arr.length == 3 )
            {
                aux3 = Integer.parseInt(arr[2]);
            }
            aux1 = Integer.parseInt(arr[0]);
            aux2 = Integer.parseInt(arr[1]);
            if( aux1 == 1 )
            {
                arrInt[aux2-1] = aux3 - aumento;
            }
            else if( aux1 == 2 )
            {
                aumento += aux2;
            }
            else
            {
                System.out.println(arrInt[ aux2 -1 ]+aumento);
            }
                
        }
        
        
    }
}