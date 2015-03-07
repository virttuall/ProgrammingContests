package codeforces;

import java.io.*;
import java.util.*;
import java.math.*;

public class CF_519C_AAndBAndTeamTraining {
	public static void main(String[] args) throws IOException {
		BufferedReader in;
		StringBuilder out = new StringBuilder();
		File file = new File("in");
		if (file.exists())
			in = new BufferedReader(new FileReader(file));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		String line, lines[];
		lines = in.readLine().split(" ");
		int n = Integer.parseInt(lines[0]);
		int m = Integer.parseInt(lines[1]);
		int e1, e2, q1 = 0, q2 = 0, max;
		e1 = Math.min(n/2, m);
		q1 = n - e1*2;
		q2 = m - e1;
		e2 = Math.min(q1, q2/2);
		q1 = q1 - e2;
		q2 = q2 - e1*2;
		max = e1 + e2;
		while( e1 > 0 )
		{
			e1--;
			q1 = n - e1*2;
			q2 = m - e1;
			e2 = Math.min(q1, q2/2);
			q1 = q1 - e2;
			q2 = q2 - e1*2;
			max = Math.max(max, e1+e2);
		}
		System.out.println(max);
	}
}
