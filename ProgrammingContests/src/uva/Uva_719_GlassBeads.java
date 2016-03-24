package uva;

import java.util.*;
import java.io.*;
import java.math.*;

public class Uva_719_GlassBeads
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder("");
		int n = Integer.parseInt(in.readLine());
		String line;
		int sa1[];
		int leS;
		for ( int i = 0; i < n; i++ )
		{
			line = in.readLine();
			line = line+line+(char)(123);
			S = line;
			sa1 = suffixArray();
			leS = line.length()-1;
			for( int j = 0; j  < leS; j++)
			{
				if ( sa1[j] < leS>>1)
				{
					out.append((1+sa1[j])+"\n");
					break;
				}
			}
		}
		System.out.print(out);
	}
    // sort suffixes of S in O(n*log(n))
    public static CharSequence S;
    public static Comparator<Integer> comparador = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                    return S.charAt(o1) - S.charAt(o2);
            }
    };
    public static int[] suffixArray() {
            int n = S.length();
            Integer[] order = new Integer[n];
            for (int i = 0; i < n; i++)
                    order[i] = n - 1 - i;

            // stable sort of characters
            Arrays.sort(order,
                            comparador);

            int[] sa = new int[n];
            int[] classes = new int[n];
            for (int i = 0; i < n; i++) {
                    sa[i] = order[i];
                    classes[i] = S.charAt(i);
            }
            for (int len = 1; len < n; len *= 2) {
                    int[] c = classes.clone();
                    for (int i = 0; i < n; i++) {
                            classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]]
                                            && sa[i - 1] + len < n
                                            && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]]
                                            : i;
                    }
                    // Suffixes are already sorted by first len characters
                    // Now sort suffixes by first len * 2 characters
                    int[] cnt = new int[n];
                    for (int i = 0; i < n; i++)
                            cnt[i] = i;
                    int[] s = sa.clone();
                    for (int i = 0; i < n; i++) {
                            int s1 = s[i] - len;
                            if (s1 >= 0)
                                    sa[cnt[classes[s1]]++] = s1;
                    }
            }
            return sa;
    }
}