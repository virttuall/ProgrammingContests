import java.io.*;
import java.util.*;
import java.math.*;

public class Yachtzee {
public static void main(String[] args)  throws IOException {
	int T;
	long A, B, N, data[], C, S, ll, ld, raz;
	File file = new File("yachtzee.txt");
	BufferedReader in = new BufferedReader( file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	PrintWriter print = new PrintWriter("salida1_3.txt");
	T = Integer.parseInt(in.readLine());
	String lines[];
	LinkedList<Long> list;
	for( int t = 1; t <= T; t++ )
	{
		S = 0;
		lines = in.readLine().split("\\s+");
		N = Integer.parseInt(lines[0]);
		A = Integer.parseInt(lines[1]);
		B = Integer.parseInt(lines[2]);
		data = parseLong(in.readLine());
		C = sum(data);
		ll = A;
		raz = getRaz(A, C);
		S += ( raz*C)*(B-A);
		ld = raz*C;
		list = new LinkedList<Long>();
		for( int i =0; i< N; i++) list.add(data[i]);
		for( int i = 0; i < N; i++ )
		{
			ld = ld + data[i];
			ll = max(ll, ld);
			if ( ld < B)
			{
				S += data[i]*(B-ll);	
			}
			else
			{
				
				break;
			}
			
		}
		if ( ld < B)
			S += getSum(list, B-ld);
		double result = getResult(A, B, S);
		String SP = String.format(Locale.US, "Case #"+ t +": %.9f", result);
		System.out.println( SP);
		
		print.println(SP);
		
		
	}
	print.close();
}
public static double getResult(long AA, long BB, long VV)
{
//	double DA = new Double(AA);
//	double DB = new Double(BB);
//	double DV = new Double(VV);
//	return ((DA+DB)/2.0)-(DV/(DB-DA));
	BigDecimal A = new BigDecimal(""+AA);
	BigDecimal B = new BigDecimal(""+BB);
	BigDecimal V = new BigDecimal(""+VV);
	BigDecimal T = new BigDecimal(""+2);
	BigDecimal P1 = A.add(B);
	P1 = P1.divide(T,50 ,RoundingMode.HALF_UP);
	BigDecimal P2 = B.subtract(A);
	P2 = V.divide(P2,50, RoundingMode.HALF_UP);
	return (P1.subtract(P2)).doubleValue();
}
public static long getSum( LinkedList<Long> list, long B)
{
	long Z = 0, W = 0;
	long value;
	for( int i = 0; i < list.size(); i++ )
	{
		value = list.get(i);
		Z += value;
		W += Z*value;
	}
	long C = B/Z;
	long O = ((C-1)*(C))/2;
	long result = C*B*Z - C*W - Z*Z*O;
	long nB = B;
	nB -= Z*C;
	for( int i = 0; i< list.size(); i++ )
	{
		value = list.get(i);
		if ( nB >= value )
		{
			nB -= value;
			result += value*nB;
		}
		else
		{
			break;
		}
	}
	return result;
}
public static long max(long a ,long b)
{
	if ( a > b) return a;
	return b;
}
public static long getRaz(long A, long C)
{
	BigInteger BA = new BigInteger(""+A);
	BigInteger BC = new BigInteger(""+C);
	return BA.divide(BC).longValue();
}
public static long sum( long[] data)
{
	long result = 0l;
	for( int i = 0; i< data.length; i++ )
	{
		result += data[i];
	}
	return result;
}
public static long[] parseLong(String line)
{
	String lines[] = line.split("\\s+");
	long result[] = new long[lines.length];
	for( int i = 0; i < result.length; i++ )
	{
		result[i] = Long.parseLong(lines[i]);
	}
	return result;
}
}
