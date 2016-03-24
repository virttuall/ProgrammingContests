package uva;

import java.util.*;
import java.io.*;
import java.math.*;

public class Uva_719_GlassBeads2
{
	public static char[] T;
    public static int n, r, auxR;
    public static int RA[], tempRA[];
    public static int SA[];
    public static List<Integer> rk[];

    public static void sort(int k)
    {
        int maxi = Math.max(n, 300);
        rk = new ArrayList[maxi];
        rk[0] = new ArrayList<Integer>(); 
        for ( int i = 0; i < n; i++ )
        {
            if ( SA[i] + k < n )
            {
                auxR = RA[SA[i]+k];
                if (rk[auxR] == null ) rk[auxR] = new ArrayList<Integer>();
                rk[auxR].add(SA[i]);
            }
            else
            {
                rk[0].add(SA[i]);
            }
        }
        int index = 0;
        for( int i = 0; i < maxi; i++ )
        {
            if ( rk[i] != null )
            {
                for( int j = 0; j < rk[i].size(); j++ )
                {
                    SA[index++] = rk[i].get(j);
                }
            } 
        }
    }
    public static void constructSA()
    {
        RA = new int[n];
        tempRA = new int[n];
        SA = new int[n];
        for( int i = 0; i < n; i++ )
        {
            RA[i] = T[i];
            SA[i] = i;
        }
        for ( int k = 1; k < n; k <<= 1)
        {
            sort(k);
            sort(0);
            tempRA[SA[0]] = r = 0;
            for ( int i = 1; i < n; i++ )
            {
                if ( RA[SA[i]] == RA[SA[i-1]] && RA[SA[i]+k] == RA[SA[i-1]+k] )
                {
                    tempRA[SA[i]] = r;
                }
                else
                {
                    tempRA[SA[i]] = ++r;
                }
            }
            for ( int i = 0; i < n; i++ )
            {
                RA[i] = tempRA[i];
            }
            if ( RA[SA[n-1]] == n-1 )
            {
                break;
            }

        }
    }
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		int nl = Integer.parseInt(in.readLine());
		String line;
		int leS;
		for ( int i = 0; i < nl; i++ )
		{
			line = in.readLine();
			line = line+line+(char)(123);
			T = line.toCharArray();
            n = T.length;
			constructSA();
			leS = line.length()-1;
			for( int j = 0; j  < leS; j++)
			{
				if ( SA[j] < leS>>1)
				{
					out.append((1+SA[j])+"\n");
					break;
				}
			}
		}
		System.out.print(out);
	}
}