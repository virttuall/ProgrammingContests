package Uva;
import java.io.*;

public class Uva_448_JillridesAgain {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int b = Integer.parseInt(in.readLine()), arr[], s, max, sum, indexi, indexj, aux;
		for (int c = 0; c < b; c++) {
			s = Integer.parseInt(in.readLine());
			max = -1;
			sum = 0;
			indexi = 0;
			indexj = 0;
			aux = 0;
			for (int i = 0; i < s - 1; i++) {
				sum += Integer.parseInt(in.readLine().trim());
				if (sum < 0) {
					aux = i + 1;
					sum = 0;
				} else if (sum > max
						|| (sum == max && i - aux > indexj - indexi)) {
					max = sum;
					indexi = aux;
					indexj = i;
				}
			}
			if (max > 0)
				out.append("The nicest part of route " + (c + 1)
						+ " is between stops " + (indexi + 1) + " and "
						+ (indexj + 2) + "\n");
			else
				out.append("Route " + (c + 1) + " has no nice parts" + "\n");
		}
		System.out.print(out);
	}
}
