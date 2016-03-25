import java.io.*;
import java.math.*;
import java.util.*;
public class CF_649A_AmityAssessment {
	public static String rev(String r)
	{
		return new StringBuilder(r).reverse().toString();
	}
public static void main(String[] args) throws IOException {
	File file = new File("in");
	BufferedReader in = new BufferedReader(file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder("");
	String line, lines[];
	String l1, l2, a1, a2;
	l1 = in.readLine();
	l2 = in.readLine();
	a1 = in.readLine();
	a2 = in.readLine();
	
	String l = l1.replace("X", "")+ rev(l2).replace("X", "");
	String a = a1.replace("X", "")+ rev(a2).replace("X", "");
	boolean flag = false;
	for( int i = 0; i < 3; i++ )
	{
		if ( l.charAt(i) == a.charAt(0) && l.charAt((i+1)%3) == a.charAt(1) && l.charAt((i+2)%3) == a.charAt(2))
		{
			flag = true;
		}
	}
	if ( flag) System.out.println("YES");
	else System.out.println("NO");
}
}
