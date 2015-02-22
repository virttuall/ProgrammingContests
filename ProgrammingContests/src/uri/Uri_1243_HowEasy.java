package uri;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Uri_1243_HowEasy {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int average , c ;
	Pattern pat = Pattern.compile("[a-zA-Z]+");
	while ((line = in.readLine()) != null) {
		lines = line.split("\\s++");
		average = 0; c = 0;
		for ( int i = 0; i < lines.length; i++ )
		{
			if ( lines[i].endsWith("."))
			{
				if ( lines[i].length() == 1) continue;
				lines[i] = lines[i].substring(0, lines[i].length()-1);
			}
			if ( pat.matcher(lines[i]).matches() )
			{
				average += lines[i].length();
				c += 1.0;
			}			
		}
		if ( c < 1.0) average = 0;
		else average =average/ c;
		if (average <= 3.0) System.out.println(250);
		else if ( average >= 6) System.out.println(1000);
		else System.out.println(500);
	}
}
}
