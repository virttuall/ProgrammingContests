package templates;



public class FenwickTree {
	int ft[];
	FenwickTree( int n){ ft = new int[n+1]; }
	int LSOne( int i ) { return i & (-i);}
	int rsq( int a) 
	{ 
		int sum = 0;
		for (; a != 0; a -=LSOne(a)) sum += ft[a];
		return sum;
	}
	int rsq( int a, int b)
	{
		return rsq(b) - ( a == 1 ? 0 : rsq(a-1));
	}
	void adjust( int k, int v)
	{
		for ( ; k < ft.length; k += LSOne(k) ) ft[k] += v;
	}
	public static void main(String[] args) {
		int f[] = {2,4,5,5,6,6,6,7,7,8,9};
		FenwickTree ft = new FenwickTree(10);
		for ( int i = 0; i < f.length; i++ ) ft.adjust(f[i], 1);
		System.out.println(ft.rsq(1,5));
	}
}