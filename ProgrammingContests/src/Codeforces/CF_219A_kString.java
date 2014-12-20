package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_219A_kString {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	int k = Integer.parseInt( input.readLine());
	String cadena = input.readLine();
	char[] letras = new char[26];
	for( int i = 0; i < cadena.length(); i++ )
	{
		letras[cadena.charAt(i)- 97]++;
	}
	boolean flag = true;
	for( int i = 0; i < 26; i++ )
	{
		if ( letras[i]%k != 0) {flag = false;break;}
	}
	if( !flag){
		System.out.println("-1"); return;
	}
	String rs = "",rt = "";
	for( int i = 0; i < 26; i++ )
	{
		for( int j = 0; j < letras[i]/k; j++)
		
		rs += ""+(char)(97+i);
	}
	for( int i = 0; i < k; i++ )
		rt += rs;
	System.out.println(rt);
	
}
}