package uri;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Uri_1729_AverageIsNotFastEnought {
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int n;
	double d;
	lines = in.readLine().split(" ");
	n = Integer.parseInt(lines[0]);
	d = Double.parseDouble(lines[1]);
	int auxl = -1;
	boolean flag;
	int h, m, s;
	String time[];
	double ss;
	String ot;
	while ((line = in.readLine()) != null) {
		flag = false;
		for ( int i= 0; i< line.length(); i++ )
		{
			if ( flag && line.substring(i ,i+1).equals(" "))
			{
				auxl = i;
				break;
			}
			if ( !line.substring(i, i+1).equals(" ") ) flag = true;
			
		}
		out.append(line.substring(0, auxl)+": ");
		lines = line.trim().split("\\s+");
		flag = false;
		h = m = s = 0;
		for( int i = 1; i <= n; i++ )
		{
			time = lines[i].split(":");
			try
			{
				h += Integer.parseInt(time[0]);
				m += Integer.parseInt(time[1]);
				s += Integer.parseInt(time[2]);
			}
			catch(Exception e)
			{
				flag = true;
				break;
			}
		}
		if ( flag )
		{
			out.append("-\n");
		}
		else
		{
			s = s + m*60 + h*3600;
			ss = s;
			ss = ss/d;
			s = (int)Double.parseDouble(String.format("%.0f", ss));
			ot = ""+(s%60);
			if ( ot.length() == 1) ot = "0"+ot;
			out.append((s/60)+":"+ot+" min/km\n");
		}
	}
	System.out.print(out);
}
}
