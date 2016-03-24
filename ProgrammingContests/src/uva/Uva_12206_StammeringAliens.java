//Cambiar el nombre de la clase a Main y tambien en la linea 188
//se hace buscando el min en un intervalo m dentro del array LCP



import java.io.*;
import java.math.*;
import java.util.*;


public class Uva_12206_StammeringAliens
{
	private class Node
	{
		int value;
		int index;
		Node left;
		Node right;
		public Node(int _value, int _index)
		{
			value = _value;
			index = _index;
		}
	}
	Node start;
	Node finish;
	public void add(int value, int index)
	{
		Node aNode = new Node(value, index);
		if ( start == null || start.value >= value)
		{
			start = aNode;
			finish = aNode;
		}
		else
		{
			Node aux = finish;
			while( aux.value >= value )	aux = aux.left;
			aux.right = aNode;
			aNode.left = aux;
			finish = aNode;
		}
	}
	public void poll(int index)
	{
		if ( start != null && start.index == index )
		{
			if ( start.right == null )
			{
				start = null; 
				finish = null;
			}
			else
			{
				start = start.right;
				start.left = null;
			}
		}
	}
	public String toString()
	{
		Node aux = start;
		String result = "result = ";
		result += aux.value+" ";
		while( aux != finish )
		{
			aux = aux.right;
			result += aux.value+" ";
		}
		return result;
	}
	public int min()
	{
		return start.value; 
	}

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

	public static int Phi[];
	public static int PLCP[];
	public static int LCP[];


	public static void computeLCP()
	{
		Phi = new int[n];
		PLCP = new int[n];
		LCP = new int[n];
		Phi[SA[0]] = -1;
		for( int i = 1; i < n; i++ )
		{
			Phi[SA[i]] = SA[i-1];
		}
		for( int i = 0, L = 0; i < n ; i++ )
		{
			if ( Phi[i] == -1 ) 
			{
				PLCP[i] = 0; 
				continue;
			}
			while( T[i+L] == T[Phi[i]+L]) L++;
			PLCP[i] = L;
			L = (int)(Math.max(L-1, 0));
		}
		for( int i = 0; i < n; i++ )
		{
			LCP[i] = PLCP[SA[i]];
		}
	}
	static ArrayList<Integer> is;
	static ArrayList<Integer> js;
	public static int result( int f)
	{
		if ( f > n) return 0;
		int result;
		Uva_12206_StammeringAliens minA = new Uva_12206_StammeringAliens();
		for( int i = 0; i < f; i++ )
		{
			minA.add(LCP[i],i);
		}
		is = new ArrayList<Integer>();
		js = new ArrayList<Integer>();
		result = minA.min();
		is.add(0); 
		js.add(f-1);
		for( int i = f; i < n; i++ )
		{
			minA.poll(i-f);
			minA.add(LCP[i], i);
			int aux = minA.min();
			//System.out.println("aux = "+aux);
			if ( aux > result )
			{
				is  = new ArrayList<Integer>();
				js = new ArrayList<Integer>();
				result = aux;
				is.add(i-f+1);
				js.add(i);
			}
			if ( aux == result )
			{
				is.add(i-f+1);
				js.add(i);
			}
		}
		return result;
	}
	public static int result2()
	{
		int result = Integer.MIN_VALUE;
		int arr1[] = new int[n+1];
		for( int i = 0; i < is.size(); i++ )
		{
			arr1[is.get(i)-1]++;
			arr1[js.get(i)+1]--;
		}		
		for( int i = 1; i <= n; i++ )
		{
			arr1[i] = arr1[i-1]+arr1[i];
			if ( arr1[i] > 0) 
				result = (int)(Math.max(result, SA[i]));
		}
		return result;

	}
	public static void main(String[] args) throws IOException
	{
		StringBuilder out = new StringBuilder();
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		String line;
		int res1,res2 = 0;
		while( (line = in.readLine()) != null)
		{
			line = line.trim();
			if ( line.equals("0")) break;
			int m = Integer.parseInt(line);
			T = (in.readLine().trim()+"$").toCharArray();
			n = T.length;
			if ( m == 1)
			{
				out.append((n-1)+" 0\n");
			}
			else
			{
				constructSA();
				computeLCP();
				res1 = result(m-1);
				if ( res1 == 0)
				{
					out.append("none\n");
				}
				else
				{
					res2 = result2();
					out.append(res1+" "+res2+"\n");
				}
			}	

		}
		System.out.print(out);
	}
}