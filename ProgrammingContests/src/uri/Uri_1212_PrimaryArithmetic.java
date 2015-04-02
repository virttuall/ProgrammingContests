package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class Uri_1212_PrimaryArithmetic {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[], line1 ,line2;
	int count, c, maxLenght, aux;
	while ((line = in.readLine()) != null && !line.equals("0 0")) {
		count = 0;
		c = 0;
		lines = line.split(" ");
		maxLenght = Math.max(lines[0].length(), lines[1].length());
		while( lines[0].length() < maxLenght) lines[0] = "0"+lines[0];
		while( lines[1].length() < maxLenght) lines[1] = "0"+lines[1];
		for ( int i = maxLenght -1; i >= 0; i-- )
		{
			aux = c + Integer.parseInt(lines[0].charAt(i)+"")+ Integer.parseInt(lines[1].charAt(i)+"");
			if ( aux >= 10 )
			{
				count++;
				c = aux / 10;
			}
			else
			{
				c = 0;
			}
		}
		if ( count == 0) {out.append("No carry operation.\n");}
		else if ( count == 1){out.append("1 carry operation.\n");}
		else {out.append(count+" carry operations.\n");}
	}
	System.out.print(out);
}
}
