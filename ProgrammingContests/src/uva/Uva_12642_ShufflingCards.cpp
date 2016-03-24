#include <bits/stdc++.h>

#define s(n)    scanf("%d",&n)
#define sc(n)   scanf("%c",&n)
#define sl(n)   scanf("%lld",&n)
#define sf(n)   scanf("%lf",&n)
#define ss(n)   scanf("%s",n)
#define printInt(n) printf("%d\n", n)



#define maX(a,b)    ( (a) > (b) ? (a) : (b))
#define miN(a,b)    ( (a) < (b) ? (a) : (b))

using namespace std;

const int maxN = 1040;
long long R;
int N;
int f[maxN+1];
int cycles[maxN+1][maxN+1];
long long sizes[maxN+1];
int a;
long long auxS;
bool visited[maxN+1];

int main()
{
    while(cin>>N)
    {
        sl(R);
        for ( int i = 1; i <= N; i++ )
        {
            s(a);
            f[i] = a;
        }
        fill_n(sizes, maxN+1, 0);
        for ( int i = 1; i <= N; i++ )
        {
            cycles[i][0] = i;
            fill_n(visited, maxN+1, false);
            visited[i] = true;
            auxS = 1l;
            for ( int j = 1; true; j++ )
            {
                a = f[cycles[i][j-1]];
                if (visited[a])
                {
                    sizes[i] = auxS;
                    break;
                }
                auxS++;
                cycles[i][j] = a;
            }
        }
        for( int i = 1; i < N; i++ )
        {
            printf("%d ", cycles[i][int( R%sizes[i]) ] );
        }
        printf("%d\n", cycles[N][int( R%sizes[N]) ]);

    }
    return 0;
}
