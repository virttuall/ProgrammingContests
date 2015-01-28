package templates;

public class Miscellaneous {
	public static void main(String[] args) {
		//counting bits in a number ( Brian Kernighan's way ) O(log(n))
		int count = 0;
		int n = 7;  // assign the value of number
		for (; n != 0; count++) n &= (n-1);
		System.out.println("this number had "+count+" bit in up"); 
		
	}
}
