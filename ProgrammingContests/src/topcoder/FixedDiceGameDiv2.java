package topcoder;

//Accepted
import java.io.*;
import java.util.*;
import java.math.*;
public class FixedDiceGameDiv2 {
public static double getExpectation( int a, int b)
{
    double n = a, m = b, r = 0;
	if ( m >= n) return ((2*n-1)/3)+1;
	double denominator, numerator;
	numerator = ( ((m-1)*m*(2*(m-1)+1))/6 )+((m*(m-1))/2)+m*(((n*(n+1))/2)-((m*(m+1))/2));
	denominator = ((m*(m-1))/2) + (n - m)*m;
	return numerator/denominator;
}
public static void main(String[] args) {
	System.out.println(getExpectation(3, 3));
}
}
