package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_38A_Army {
public static void main(String[] args) throws IOException {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(input.readLine());
	int anos[] = new int[n-1];
	String[] line = input.readLine().split(" ");
	for( int i = 0; i < n-1; i++ )
		anos[i] = Integer.parseInt(line[i]);	
	int a, b;
	String t = input.readLine();
	a = Integer.parseInt(t.split(" ")[0]);
	b = Integer.parseInt(t.split(" ")[1]);
	int count = 0;
	for( int i = a-1; i < b-1; i++ )
	{
		count += anos[i];
	}
	System.out.println(count);
}
}