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
const int maxC = 1000;
vector<int> graph[maxC+1];
int C, P, U, V;
bool pairs[maxC+1][maxC+1];
bool flag;
int result;


int main()
{
    while(cin>>C)
    {
        s(P);
        for( int i = 1; i <= C; i++ ) graph[i] = vector<int>();
        for ( int i = 0; i<  P; i++ )
        {
            s(U); s(V);
            graph[V].push_back(U);
        }
        for( int i = 1; i <= maxC; i++ ) fill_n(pairs[i], maxC+1, false);
        for( int i = 2; i <= maxC; i++)
        {
            pairs[1][i] = true;
            pairs[i][1] = true;
        }
        for( int i = 2; i <= C; i++ )
        {
            for( int j =2; j < i; j++ )
            {
                flag = false;
                for( int k = 0; k < graph[i].size(); k++ )
                {
                    flag |= pairs[graph[i][k]][j];
                    if ( flag ) break;
                }
                pairs[i][j] = flag;
                pairs[j][i] = flag;
            }
        }
        result = 0;
        for( int i = 1; i <= C; i++ )
            for ( int j = i+1; j <= C; j++ )
                if ( pairs[i][j]) result++;
        printInt(result);

    }
    return 0;
}
