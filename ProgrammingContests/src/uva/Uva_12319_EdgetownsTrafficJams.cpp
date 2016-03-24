#include <bits/stdc++.h>

#define s(n) scanf("%d\n", &n)
#define forT(i, a, b) for( int i = a; i <= b; i++ )
#define miN(a,b)    ( (a) < (b) ? (a) : (b))
using namespace std;

int N, A, B, node, neig;
char line[100000];
char *token;
const int maxN = 100;
int graph1[maxN+1][maxN+1];
int graph2[maxN+1][maxN+1];
bool flag;

int main()
{
	while(true)
	{
		s(N);
		if ( N == 0 ) break;
		forT(i, 1, N)
		{
			forT(j, 1, N)
			{
				graph1[i][j] = 9999999;
				graph2[i][j] = 9999999;
			}
		}
		forT(i, 1, N)
		{
			gets(line);
			token = strtok(line, " "); 
			while( token != NULL )
			{
				graph1[i][atoi(token)] = 1;
				token = strtok(NULL, " ");
			}
		}
		forT(i, 1, N)
		{
			gets(line);
			token = strtok(line, " "); 
			while( token != NULL )
			{
				graph2[i][atoi(token)] = 1;
				token = strtok(NULL, " ");
			}
		}
		forT(k, 1, N)
		{
			forT(i, 1, N)
			{
				forT(j, 1, N)
				{
					if ( i != k && j != k)
					{
						graph1[i][j] = miN(graph1[i][j], graph1[i][k]+graph1[k][j]);
						graph2[i][j] = miN(graph2[i][j], graph2[i][k]+graph2[k][j]);
					}
				}
			}
		}
		s(A);
		s(B);
		flag = true;
		for(int i = 1; i <= N && flag; i++)
		{
			forT(j, 1, N)
			{
				if (graph2[i][j] > A*graph1[i][j]+B)
				{
					flag = false;
					break;
				}	
				//printf("%d ", graph1[i][j]);
			}
			//printf("\n");
		}
		if ( flag) printf("Yes\n");
		else printf("No\n");


	}
	return 0;
}