package uri;
import java.io.*;
import java.util.*;
import java.math.*;
public class Uri_1103_AlarmClock {
public static int[] parseInts(String line) {
	String lines[] = line.split(" ");
	int n = lines.length;
	int r[] = new int[n];
	for (int i = 0; i < n; i++) {
		r[i] = Integer.parseInt(lines[i]);
	}
	return r;
}
public static void main(String[] args) throws IOException {
	BufferedReader in;
	StringBuilder out = new StringBuilder();
	File file = new File("in");
	if (file.exists())
		in = new BufferedReader(new FileReader(file));
	else
		in = new BufferedReader(new InputStreamReader(System.in));
	String line, lines[];
	int arr[];
	while ((line = in.readLine()) != null && !line.equals("0 0 0 0")) {
		arr = parseInts(line);
		arr[1] += arr[0]*60;
		arr[3] += arr[2]*60;
		System.out.println((arr[3]- arr[1] + 24*60)%(24*60));
	}
	System.out.print(out);
}
}
