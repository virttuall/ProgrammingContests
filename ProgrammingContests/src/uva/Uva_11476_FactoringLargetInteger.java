import java.io.*;
import java.util.*;
import java.math.*;
import java.security.SecureRandom;

public class Uva_11476_FactoringLargetInteger
{
	static BigInteger ZERO = new BigInteger("0");
    static BigInteger ONE  = new BigInteger("1");
    static BigInteger TWO  = new BigInteger("2");
    static SecureRandom random = new SecureRandom();
    static ArrayList<BigInteger> divisors; // esta lista no siempre esta ordenada

    public static BigInteger rho(BigInteger N) {
        BigInteger divisor;
        BigInteger c  = new BigInteger(N.bitLength(), random);
        BigInteger x  = new BigInteger(N.bitLength(), random);
        BigInteger y = x;
        if (N.mod(TWO).compareTo(ZERO) == 0) return TWO;
        do {
            x  =  x.multiply(x).mod(N).add(c).mod(N);
            y = y.multiply(y).mod(N).add(c).mod(N);
            y = y.multiply(y).mod(N).add(c).mod(N);
            divisor = x.subtract(y).gcd(N);
        } while((divisor.compareTo(ONE)) == 0);
        return divisor;
    }

    public static void factor(BigInteger N) {
        if (N.compareTo(ONE) == 0) return;
        if (N.isProbablePrime(20)) { divisors.add(N);return; } 
        BigInteger divisor = rho(N);
        factor(divisor);
        factor(N.divide(divisor));
    }

    public static void main(String[] args) throws IOException
    {
    	BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
    	StringBuilder out = new StringBuilder("");
    	int n = Integer.parseInt(in.readLine());
    	BigInteger base;
    	int exp;
    	String result;
    	String line;
    	for( int i = 0; i<  n; i++ )
    	{
    		divisors = new ArrayList<BigInteger>();
    		line = in.readLine();
    		factor( new BigInteger(line));
    		
    		exp = 0;
    		result = line +" = ";
    		Collections.sort(divisors);
    		base = divisors.get(0);
    		for( BigInteger B : divisors )
    		{
    			if ( base.equals(B))
    			{
    				exp++;
    			}
    			else
    			{
    				if ( exp != 1)
    				{
    					result += base.toString()+ "^" + exp +" * ";
    				}
    				else
    				{
    					result += base.toString()+" * ";
    				}
    				exp = 1;
    				base = B;
    			}
    		}
    		if ( exp > 0 )
    		{
    			if ( exp != 1)
				{
					result += base.toString()+ "^" + exp +" * ";
				}
				else
				{
					result += base.toString()+" * ";
				}
    		}
    		out.append(result.substring(0, result.length()-3)+"\n");
    	}
    	System.out.print(out);
    }
}