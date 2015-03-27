package codeforces;


import java.io.*;
import java.util.*;

public class CF_GYM_NEERC14_JokeWithPermutation {
	public static class Node
	{
		Node father;
		BitSet mask;
		int number;
		public Node( Node f, BitSet m, int n)
		{
			father = f;
			mask = m;
			number = n;
		}
	}
public static void main(String[] args) throws IOException {

	BufferedReader in;
	File file = new File("joke.in");
	PrintWriter outFile = new PrintWriter("joke.out");
	if ( file.exists())
	{
		in = new BufferedReader(new FileReader(file));
	}
	else
	{
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	StringBuilder out = new StringBuilder();
	String s = "", joeyPermutation;
	HashMap<Integer, Integer> searchN = new HashMap<Integer, Integer>();
	int n, aux, auxNumber, pp, iter, c,cs[];
	BitSet auxMask, son;
	boolean cort[];
	Node auxNode = null;
	for ( int i = 1; i <= 100; i++ )
	{
		s += i+"";
		searchN.put(s.length(), i);
	}
	ArrayList<Integer> positions[] = new ArrayList[100];
	Queue<Node> queue;
	while ((joeyPermutation = in.readLine()) != null && !joeyPermutation.equals(""))
	{
		
		out = new StringBuilder();
		n = searchN.get(joeyPermutation.length());
		for ( int i = 1; i <= n; i++ )
		{
			positions[i] = new ArrayList<Integer>();
		}
		for ( int i = 0; i < joeyPermutation.length(); i++ )
		{
			pp = Integer.parseInt(joeyPermutation.substring(i, i+1));
			if ( pp != 0)
			{
				positions[pp].add(i);
			}
		}
		for ( int i = 0; i < joeyPermutation.length()-1; i++ )
		{
			aux = Integer.parseInt(joeyPermutation.substring(i, i+2));
			if ( aux <= n) 
			{
				positions[aux].add(i);
			}
		}
		queue= new LinkedList<Node>();
		queue.add(new Node(null, new BitSet(100), n));
		
		while(!queue.isEmpty())
		{
			
			auxNode = queue.poll();
			auxNumber = auxNode.number;
			auxMask = auxNode.mask;
			if ( auxNumber == 0 )
			{
				break;
			}	
			if ( auxNumber < 10 )
			{
				for ( int i = 0; i <  positions[auxNumber].size(); i++ )
				{
					aux = positions[auxNumber].get(i);
					if ( !auxMask.get(aux) )
					{
						son = ((BitSet)auxMask.clone());
						son.set(aux);
						queue.add(new Node(auxNode, son, auxNumber -1 ));
					}
				}
			}
			else
			{
				for ( int i = 0; i <  positions[auxNumber].size(); i++ )
				{
					aux = positions[auxNumber].get(i);
					if ( !auxMask.get(aux) && !auxMask.get(aux+1))
					{
						son = ((BitSet)auxMask.clone());
						son.set(aux);
						son.set(aux+1);
						queue.add(new Node(auxNode, son, auxNumber-1));
					}
				}
			}	
		}
		iter = 0;
		cs = new int[n];
		while( auxNode.father != null )
		{
			auxNode.mask.xor(auxNode.father.mask);
			cs[iter++] = auxNode.mask.length()-1;
			auxNode = auxNode.father;
		}
		cort = new boolean[joeyPermutation.length()+1];
		for ( int i = 0;  i <  n; i++ )
		{
			c = cs[i];
			if ( i < 9 )
			{
				cort[c] = true;
				cort[c+1] = true;
			}
			else
			{
				cort[c-1] = true;
				cort[c+1] = true;
			}
		}
		for ( int i = 0; i < joeyPermutation.length() ; i++ )
		{
			out.append(joeyPermutation.charAt(i));
			if (cort[i+1] && i != joeyPermutation.length()-1) out.append(" ");
		
		}
		outFile.println(out);
	}
	outFile.close();
}
}
