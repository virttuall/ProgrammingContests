#include <bits/stdc++.h>

// input macros
#define s(n)    scanf("%d",&n)
#define sc(n)   scanf("%c",&n)
#define sl(n)   scanf("%lld",&n)
#define sf(n)   scanf("%lf",&n)
#define ss(n)   scanf("%s",n)
#define printInt(n) printf("%d", n)


const int maxV = 100000;
long long x[maxV+10];
long long y[maxV+10];
int levels[maxV+10];
int fathers[maxV+10];
int n;
int table[maxV+10][30];


	//https://en.wikipedia.org/wiki/Graham_scan
long long crossProduct( int p1, int p2, int p3)
	{
		return (x[p2] - x[p1])*(y[p3] - y[p1]) - (y[p2] - y[p1])*(x[p3] - x[p1]);
	}
	//https://www.topcoder.com/community/data-science/data-science-tutorials/range-minimum-query-and-lowest-common-ancestor/
	int query( int p, int q)
	{
		int tmp, log, i;
		if ( levels[p] < levels[q])
		{
			tmp = p;
			p = q;
			q = tmp;
		}
		for ( log = 1; 1 << log <= levels[p]; log++ );
		log--;
		for ( i = log; i >= 0; i--)
			if ( levels[p] - (1 << i) >= levels[q])
				p = table[p][i];
		if ( p == q) return p;

		for( i = log; i >= 0; i-- )
			if ( table[p][i] != -1 && table[p][i] != table[q][i])
			{
				p = table[p][i];
				q = table[q][i];
			}
		return fathers[p];
	}

int main()
{
    int basura;
    s(n);
    int m;
    if ( n == 1)
    {
        for ( int i = 0; i < n; i++ )
        {
            s(basura);
            s(basura);
        }
        s(m);
        for ( int i = 0; i < m; i++ )
        {
            s(basura);
            s(basura);
            if ( i != m-1 )
                printf("1 ");
            else
                printf("1\n");
        }
    }
    else
    {
      for ( int i = 0; i < n; i++ )
      {
        scanf("%lld",x+i);
        scanf("%lld",y+i);
      }

        s(m);
        fathers[n-1] = -1;
        fathers[n-2] = n-1;
        levels[n-1] = 0;
        levels[n-2] = 1;
        int aux;
        long long resultCP;
        for ( int i = n-3; i >= 0; i--)
        {
            aux = i+1; // siguiente
            fathers[i] = n-1;
            levels[i] = 1;
            while( fathers[aux] != -1)
            {
                resultCP = crossProduct(i, aux, fathers[aux]);
                if ( resultCP <= 0ll )
                {
                    fathers[i] = aux;
                    levels[i] = levels[aux] + 1;
                    break;
                }
                aux = fathers[aux];
            }
        }
        	fathers[n-1] = n-1;
            for ( int i = 0; i < n; i++ )
            {
                for ( int j = 0; j < 30; j++ ) table[i][j] = -1;

            }
            for ( int i = 0; i < n; i++ )
                table[i][0] = fathers[i];
            for ( int j = 1; 1 << j < n; j++)
                for ( int i = 0; i < n; i++ )
                    if ( table[i][j-1] != -1)
                        table[i][j] = table[table[i][j-1]][j-1];



            int v1, v2;
            for ( int i = 0; i < m; i++ )
            {
                s(v1);
                s(v2);
                printInt(query(v1-1, v2-1)+1);
                if (i != m-1 )
                {
                    printf(" ");
                }
                else{
                    printf("\n");
                }

            }
    }
    return 0;
}
