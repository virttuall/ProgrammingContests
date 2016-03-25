import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class HighSecurity {
public static void main(String[] args) throws IOException{
	File file = new File("high_security.txt");
	StringBuilder out = new StringBuilder("");
	BufferedReader in;
	if ( file.exists() ) in = new BufferedReader( new FileReader(file));
	else in = new BufferedReader( new InputStreamReader(System.in));
	int T, N;
	T = Integer.parseInt(in.readLine());
	char[][] maze;
	int l, r;
	int result;
	PrintWriter print = new PrintWriter("salida2.txt");
	for( int t = 0; t < T; t++ )
	{
		N = Integer.parseInt(in.readLine());
		maze = new char[2][N+2];
		maze[0] = ("X"+in.readLine().trim()+"X").toCharArray();
		maze[1] = ("X"+in.readLine().trim()+"X").toCharArray();
		result = 0;
		for( int j = 1; j <= N; j++ )
		{
			for( int i = 0; i <  2; i++ )
			{
				if ( maze[i][j+1] == 'X' && maze[i][j-1] == 'X' && maze[i][j] == '.')
				{
					maze[i][j] = 'X';
					result++;
					if ( maze[(i+1)%2][j] == '.' )
					{
						maze[(i+1)%2][j] = 'X';
						l = r = j;
						l--;
						r++;
						while( l >= 1 && maze[(i+1)%2][l] == '.')
						{
							maze[(i+1)%2][l] = 'X';
							l--;
						}
						while( r <= N && maze[(i+1)%2][r] == '.' )
						{
							maze[(i+1)%2][r] = 'X';
							r++;
						}
					}
//					System.out.println(Arrays.toString(maze[0]));
//					System.out.println(Arrays.toString(maze[1]));
//					System.out.println();
				}
			}
		}
		for( int i = 0; i < 2; i++ )
		{
			for( int j = 0; j <= N ; j++ )
			{
				if ( maze[i][j] == 'X' && maze[i][j+1] == '.' )
				{
					result++;
				}
			}
		}
		System.out.println("Case #"+(t+1)+": "+result);
		print.println("Case #"+(t+1)+": "+result);
	
	}
	print.close();
}
}
