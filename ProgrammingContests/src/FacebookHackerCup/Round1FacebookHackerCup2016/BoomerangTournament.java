import java.io.*;
import java.util.*;
public class BoomerangTournament {
public static boolean dp[][], visit[][];
public static void main(String[] args) throws IOException {
//	System.out.println(Integer.parseInt("101111110",2));
//	System.out.println(Integer.parseInt("1010100",2));
//	System.out.println(Integer.parseInt("1010110",2));
//	System.out.println(f(382,84));
	File file = new File("boomerang_tournament.txt");
	BufferedReader in = new BufferedReader( file.exists() ? new FileReader(file) : new InputStreamReader(System.in));
	PrintWriter print = new PrintWriter("salida1_4.txt");
	int T = Integer.parseInt(in.readLine());
	boolean matrix[][];
	int M;
	String lines[];
	int N;
	int C_1[] = new int[16], iC_1 = 0;
	int C_2[] = new int[120], iC_2 = 0;
	int C_4[] = new int[1820], iC_4 = 0;
	int C_8[] = new int[12870], iC_8 = 0;
	int C_16[] = new int[1], iC_16 = 0;
	int C_7_3[] = new int[35], iC_7_3 = 0;
	int C_15_7[] = new int[6435], iC_15_7 = 0;
	int p1, p2;
	for(int i = 1 ; i < (1<<7); i++ )
	{
		if ( Integer.bitCount(i) == 3 ) C_7_3[iC_7_3++] = i;
	}
	for(int i = 1; i < (1<<15); i++)
	{
		if ( Integer.bitCount(i) == 7 ) C_15_7[iC_15_7++] = i;
	}
	int count, value, co,xo,xoX, aux, auxX, LSOne;
	for( int t = 1; t <= T; t++ )
	{
		N = Integer.parseInt(in.readLine());
		M = 1<<N;
		iC_1 = iC_2 = iC_4 = iC_8 = iC_16 = 0;
		for( int i = 1; i < M; i++ )
		{
			count = Integer.bitCount(i);
			if ( count == 1 )
			{
				C_1[iC_1++] = i;
			}
			else if ( count == 2)
			{
				C_2[iC_2++] = i;
			}
			else if ( count == 4)
			{
				C_4[iC_4++] = i;
			}
			else if ( count == 8)
			{
				C_8[iC_8++] = i;
			}
			else if ( count == 16 )
			{
				C_16[iC_16++] = i;
			}
		}
		matrix = new boolean[N][N];
		dp = new boolean[N][M];
		for( int i = 0; i < N; i++ )
		{
			lines = in.readLine().split("\\s+");
			for( int j = 0; j < N; j++  )
			{
				matrix[i][j] = lines[j].equals("1");
			}
		}
		for( int i = 0; i < N; i++ ) //1
		{
			dp[i][1<<i] = true;
		}
		if ( N >= 2)
		{
			for( int i = 0; i < iC_2; i++)
			{
				value = C_2[i];
				co = 0;
				for( int j = 0; j < N && co < 2; j++ )
				{
					if ( (value >> j) % 2 == 1 )
					{
						co++;
						LSOne = value - (1<<j);
						for( int k = 0;  k < N; k++ )
						{
							if ( (LSOne >> k) % 2 == 1)
							{
								dp[j][value] = matrix[j][k];
								break;
							}
						}
					}
				}
			}
		}
		if ( N >= 4)
		{
			for( int i = 0; i < iC_4; i++ )
			{
				value = C_4[i];
				co = 0;
				T: for( int j = 0; j < N && co < 4; j++ )
				{
					if ( (value >> j ) % 2 == 1)
					{
						aux = value - (1<<j);
						co++;
						xo = 0;
						for( int k = 0; k < N && xo < 3; k++ )
						{
							if ( (aux >> k) % 2 == 1)
							{
								xo++;
								xoX = 0;
								auxX = aux - (1<<k);
								if( dp[j][((1<<j)+(1<<k))] )
								{
									for( int q = 0; q < N && xoX < 2; q++ )
									{
										if ( ( auxX >> q) % 2 == 1 )
										{
											xoX++;
											if ( matrix[j][q] && dp[q][auxX])
											{
												dp[j][value] = true;
												continue T;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ( N >= 8)
		{
			for( int i = 0; i < iC_8; i++ )
			{
				value = C_8[i];
				co = 0;
				Q: for( int j = 0; j < N && co < 8; j++ )
				{
					if ( (value >> j ) % 2 == 1)
					{
						co++;
						aux = value - (1<<j);
						for( int k = 0; k < iC_7_3; k++)
						{
							p2 = f(aux, C_7_3[k]);
							p1 = value - p2;
							if ( dp[j][p1])
							{
								for( int q = 0; q < N; q++ )
								{
									if ( (p2 >> q) % 2 == 1)
									{
										if ( matrix[j][q] && dp[q][p2])
										{
											dp[j][value]= true;
											continue Q;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		if ( N == 16)
		{
			value = 65535;
			Y: for( int j = 0; j < N ; j++ )
			{
				aux = value - (1<<j);
				for( int k = 0; k < iC_15_7; k++ )
				{
					p2 = f(aux, C_15_7[k]);
					p1 = value - p2;
					if ( dp[j][p1])
					{
						for( int q = 0; q < N; q++ )
						{
							if ( (p2 >> q) % 2 == 1)
							{
								if ( matrix[j][q] && dp[q][p2])
								{
									dp[j][value] = true;
									continue Y;
								}
							}
						}
					}
				}
			}
			
		}
		int max, best, ult;
		System.out.println("Case #"+t+": ");
		print.println("Case #"+t+": ");
		int k = 0;
		for( int j = 0; j < 8; j++ )
		{
			if ( (1<<j) == N)
			{
				k = j;
				break;
			}
		}
		
		for( int i = 0; i < N; i++ )
		{
			max = Integer.MIN_VALUE;
			for( int j = 1; j < 1<<N; j++ )
			{
				if ( (j>>i) % 2 == 1 )
				{
					if( dp[i][j])
					{
						max = max(max, Integer.bitCount(j));
					}
				}
			}
			best = -1;
			ult = -1;
			for( int j = 0; j < 7; j++ )
			{
				if ( (1 << j) == max )
				{
					if ( k == j )
					{
						best = 1;
					}
					else
					{
						best = 1+(1<<(k-j-1));
					}
					
					break;
				}
			}
			boolean lose = false;
			for( int j = 0; j < N; j++ )
			{
				if ( j != i )
				{
					if ( !matrix[i][j] )
					{
						lose = true;
						break;
					}
				}
			}
			if ( lose )
			{
				if ( N == 1 )
				{
					ult = 1;
					
				}
				else
				{
					ult = 1 + ( 1<<(k-1));
				}
			}
			else
			{
				ult = 1;
			}
			System.out.println(best+" "+ult);
			print.println(best+" "+ult);
		}
	}
	print.close();
}
public static int max( int a, int b)
{
	if ( a > b) return a;
	return b;
}
public static int f(int value, int qi)
{
	int result = value;
	int i = 0;
	while( qi != 0)
	{
		while( (value>>i) % 2 == 0) i++;
		if ( qi % 2 == 1) result = result - (1<<i);
		qi = qi>>1;
		i++;
	}
	
	return result;
}

}
