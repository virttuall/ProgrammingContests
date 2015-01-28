package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.TreeSet;


public class CF_230B_T_primes {
    
    public static ArrayList<Integer> numerosPrimos(int n) {
    if (n < 2)  return new ArrayList<Integer>();
    char[] is_composite = new char[(n - 2 >> 5) + 1];
    final int limit_i = n - 2 >> 1, limit_j = 2 * limit_i + 3;
    ArrayList<Integer> results = new ArrayList<>((int) Math.ceil(1.25506    * n / Math.log(n)));
    results.add(2);
    for (int i = 0; i < limit_i; ++i) 
        if ((is_composite[i >> 4] & 1 << (i & 0xF)) == 0) {
            results.add(2 * i + 3);
            for (long j = 4L * i * i + 12L * i + 9; j < limit_j; j += 4 * i + 6) 
                is_composite[(int) (j - 3L >> 5)] |= 1 << (j - 3L >> 1 & 0xF);
        }
    return results;
}

    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        
        ArrayList<Integer> primos = numerosPrimos(1000000);
        ArrayList<String> primoT = new ArrayList<String>();
        String[] datos;
        long aux;
        for(int j = 0; j  < primos.size(); j++ ) { aux = primos.get(j); aux*=aux; primoT.add(""+aux);}
        int i = Integer.parseInt(input.readLine());
        datos = input.readLine().split(" ");
        TreeSet<String> set = new TreeSet<String>();
        for( int j = 0; j < primoT.size(); j++ )
            set.add(primoT.get(j));
        for( int j = 0; j < i; j++ )
        {
            if ( set.contains(datos[j])) output.append("YES\n");
            else output.append("NO\n");
        }
        System.out.print(output);
    }
}