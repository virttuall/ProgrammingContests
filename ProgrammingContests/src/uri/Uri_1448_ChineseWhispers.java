package uri;
import java.io.*;
import java.util.*;
import java.math.*;
public class Uri_1448_ChineseWhispers {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	char original[], team1[], team2[];
	int n = Integer.parseInt(in.readLine()), cteam1, cteam2;
	for ( int i =0 ; i < n; i++ )
	{
		cteam1 = cteam2 = 0;
		original = in.readLine().toCharArray();
		team1 = in.readLine().toCharArray();
		team2 = in.readLine().toCharArray();
		System.out.println("Instancia "+(i+1));
		for ( int j = 0; j < original.length; j++ )
		{

			if ( original[j] == team1[j]) cteam1++;
			if ( original[j] == team2[j]) cteam2++;
		}
		if ( cteam1 == cteam2)
		{
			int k = 0;
			for ( ; k < original.length; k++ )
			{
				if ( original[k] == team1[k] && original[k] != team2[k])
				{
					System.out.println("time 1");
					break;
				}
				if ( original[k] != team1[k] && original[k] == team2[k])
				{
					System.out.println("time 2");
					break;
				}
			}
			if ( k == original.length) System.out.println("empate");
		}
		else if ( cteam1 > cteam2)
		{
			System.out.println("time 1");
		}
		else
		{
			System.out.println("time 2");
		}
		System.out.println();
	}
	
}
}
