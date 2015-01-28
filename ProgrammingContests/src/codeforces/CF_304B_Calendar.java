package codeforces;

import java.math.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.*;

public class CF_304B_Calendar{
	
	public static boolean anoB(int year)
	{
	     return ((year%4==0&&year%100!=0)||(year%400==0));
	}
public static void main(String[] args) throws IOException {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder output = new StringBuilder();
	String line1 = input.readLine(), line2 = input.readLine();
	int ano1, ano2, mes1, mes2, dia1, dia2, anoD, mesD, diaD;
	ano1 = Integer.parseInt(line1.split(":")[0]);
	mes1 = Integer.parseInt(line1.split(":")[1]);
	dia1 = Integer.parseInt(line1.split(":")[2]);
	ano2 = Integer.parseInt(line2.split(":")[0]);
	mes2 = Integer.parseInt(line2.split(":")[1]);
	dia2 = Integer.parseInt(line2.split(":")[2]);
	int[] diasMesesN = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int[] diasMesesB = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	if ( ano1*10000+mes1*1000+dia1 < ano2*10000+mes2*1000+dia2)
	{
		anoD = ano1;
		mesD = mes1;
		diaD = dia1;
		ano1 = ano2;
		mes1 = mes2;
		dia1 = dia2;
		ano2 = anoD;
		mes2 = mesD;
		dia2 = diaD;
	}
	int count = 0;
	for( int i = 1900; i <= 2038; i++ )
	{
		for( int j = 1; j <= 12; j++ )
		{
			if ( anoB(i))
			{
				for( int k = 1; k <= diasMesesB[j-1] ; k++ )
				{
					
					if ( ano1 >= i )	
					{
						if ( ano1 == i )
						{
							if ( mes1 >= j)
							{
								if ( mes1 == j)
								{
									if ( dia1 >= k)
									{
										count++;
									}
								}
								else count++;
							}
						}
						else count++;
					}
					if ( i <= ano2)
					{
						if ( i == ano2 )
						{
							if ( j <= mes2)
							{
								if ( j== mes2)
								{
									if ( k <= dia2) count--;
								}
								else count--;
							}
						}
						else count--;
					}
				}
			}
			else
			{
				for( int k = 1; k <= diasMesesN[j-1] ; k++ )
				{
					if ( ano1 >= i )	
					{
						if ( ano1 == i )
						{
							if ( mes1 >= j)
							{
								if ( mes1 == j)
								{
									if ( dia1 >= k)
									{
										count++;
									}
								}
								else count++;
							}
						}
						else count++;
					}
					if ( i <= ano2)
					{
						if ( i == ano2 )
						{
							if ( j <= mes2)
							{
								if ( j== mes2)
								{
									if ( k <= dia2) count--;
								}
								else count--;
							}
						}
						else count--;
					}
				}
			}
		}
	}
	System.out.println((int)Math.abs(count));
	
}
}